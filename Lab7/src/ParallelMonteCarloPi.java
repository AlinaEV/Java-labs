import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 04.12.2016.
 */
public class ParallelMonteCarloPi {

    public static void main(String[] args) {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int nt=0;
        do {
            try {
                System.out.println("Enter the number of threads: ");
                nt = Integer.parseInt(in.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (nt==0);

        ThreadGroup tg = new ThreadGroup("main");
        int np = Runtime.getRuntime().availableProcessors();
        int i;
        long iterations=10000;

        List<MyThread> threads = new ArrayList<MyThread>();

        long startTime = System.currentTimeMillis();

        for (i=0;i<nt;i++)
            threads.add(new MyThread(iterations,"PI"+i, tg));

        i=0;
        while (i<threads.size()) {

//            if (tg.activeCount()<np) {
                MyThread t = threads.get(i);
                t.start();
                i++;
//            }
        }

        i=0;
        while(threads.size() > i)
        {
            try {
                threads.get(i++).join();
            }
            catch (InterruptedException e) {e.printStackTrace();}
        }

        double count = threads.stream()
                .mapToDouble(p -> p.getResult())
                .sum();
        double pi = 4.0*count/(double)(iterations*nt);
        System.out.printf("PI is "+ pi);
        long finishTime = System.currentTimeMillis();
        System.out.printf("\nTREADS %d\nITERATIONS %d \nTIME %g ms\n", nt, iterations,(double)(finishTime-startTime));
    }
}


