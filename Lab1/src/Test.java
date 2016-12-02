/**
 * Created by Алина on 18.09.2016.
 */
import java.io.*;

public class Test {

    public static void main(String[] argv) throws Exception {

        for (;;) {

            ClassLoader loader = new MyClassLoader(new String[] {"D:\\KPI\\5kurs\\Java\\Lab1\\out\\production\\Lab1"});

            Class clazz= Class.forName("TestModule",true,loader);

            Object object= clazz.newInstance();

            System.out.println(object);

            new BufferedReader(new InputStreamReader(System.in)).readLine();

        }

    }

}