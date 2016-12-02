/**
 * Created by Алина on 18.09.2016.
 */

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class MyClassLoader extends ClassLoader {

    private java.util.Map classesHash = new java.util.HashMap();

    public final String[] classPath;

    public MyClassLoader(String[] classPath) {

        this.classPath = classPath;

    }

    protected synchronized Class loadClass(String name, boolean resolve)

            throws ClassNotFoundException

    {

        Class result = findClass(name);

        if (resolve) resolveClass(result);

        return result;

    }

    protected Class findClass(String name)

            throws ClassNotFoundException

    {

        Class result= (Class)classesHash.get(name);

        if (result!=null) {

          System.out.println("% Class "+name+" found in cache");

          return result;

        }

    File f= findFile(name.replace('.','/'),".class", classPath);
        String[] javaPath = {"D:\\KPI\\5kurs\\Java\\Lab1\\src"};

        File f2= findFile(name.replace('.','/'),".java", javaPath);


        String[] args = {};

        CharArrayWriter writer = new CharArrayWriter();

//        int result2 = com.sun.tools
//                .javac.Main.compile(
//
//                args,
//
//                new PrintWriter(writer, true));
//
//        if (result2 != 0) {
//
//            writer.toString();
//
//        }

        System.out.println("% Class " + name + (f == null ? "" : " found in " + f));


        if (f == null) {

            return findSystemClass(name);

        }

        String classPath = "D:\\KPI\\5kurs\\Java\\Lab1\\out\\production\\Lab1";
        if (f.lastModified() < f2.lastModified()) {
            String[] arg = new String[]{"-d", classPath, f2.getAbsolutePath()};
            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
            javac.run(null, null, null, arg);
        }

        try {

            byte[] classBytes = loadFileAsBytes(f);

            result = defineClass(name, classBytes, 0, classBytes.length);

        } catch (IOException e) {

            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);

        } catch (ClassFormatError e) {

            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);

        }

        classesHash.put(name, result);

        return result;

    }

    protected java.net.URL findResource(String name) {

        File f = findFile(name, "", classPath);

        if (f == null) return null;

        try {

            return f.toURL();

        } catch (java.net.MalformedURLException e) {

            return null;

        }

    }


    private File findFile(String name, String extension, String[] path) {


        for (int k = 0; k < path.length; k++) {

            File f = new File((new File(path[k])).getPath() + File.separatorChar + name.replace('/', File.separatorChar) + extension);

            if (f.exists()) return f;

        }

        return null;

    }

    public static byte[] loadFileAsBytes(File file)

            throws IOException

    {

        byte[] result = new byte[(int) file.length()];

        FileInputStream f = new FileInputStream(file);

        try {

            f.read(result, 0, result.length);

        } finally {

            try {

                f.close();

            } catch (Exception e) {

                // Игнорируем исключения, возникшие при вызове close.

            };

        }

        return result;

    }

}