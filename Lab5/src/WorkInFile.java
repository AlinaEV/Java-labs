import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Алина on 06.11.2016.
 */

public class WorkInFile {
    public static void main(String[] args) throws IOException {
        List<String> listoflines = new ArrayList<String>();

        String fileName ="C://SomeDir//file1.txt";
        listoflines=readFile(fileName);

        /*Unsorted List*/
        System.out.println("Before Sorting:");
        for(String counter: listoflines){
            System.out.println(counter);
        }

        listoflines=sortList(listoflines);

	    /* Sorted List*/
        System.out.println("After Sorting:");
        for(String counter: listoflines){
            System.out.println(counter);
        }

        /*write to another file*/
        String fileName2 ="C://SomeDir//file2.txt";
        writeFile(fileName2,listoflines);
//        Files.write(Paths.get(fileName2), listoflines);
    }

    public static List<String> readFile(String fileName) throws IOException {
        List<String> listoflines = new ArrayList<String>();

        InputStream is = new FileInputStream(fileName);
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=r.readLine()) != null) {
                listoflines.add(line);
            }

//        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
//            listoflines=stream.collect(Collectors.toList());
//        }catch(IOException e) {
//            e.printStackTrace();
//        }

//        try (Scanner scanner = new Scanner(new File(fileName))) {
//            while (scanner.hasNextLine()) {
//                listoflines.add(scanner.nextLine());
//            }
//            scanner.close();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

        return listoflines;
    }

    public static void writeFile(String fileName2,List<String> listoflines) throws IOException {
        Writer writer = null;
        try {
            FileOutputStream out=new FileOutputStream(fileName2);
            writer = new OutputStreamWriter(out, "UTF8");
            for(String line: listoflines) {
                writer.write(line+"\n");
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static List<String> sortList(List<String> listoflines) {
        Comparator<String> x = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return -1;

                if (o2.length() > o1.length())
                    return 1;

                return 0;
            }
        };
        Collections.sort(listoflines, x);
//        List<String> sortedlist = Files.lines(Paths.get("C://SomeDir//file1.txt")).sorted((a,b)-> Integer.compare(b.length(), a.length())).collect(Collectors.toList());
        return listoflines;
    }
}
