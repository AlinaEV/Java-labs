/**
 * Created by Алина on 05.12.2016.
 */
public class MyThread extends Thread {
    protected double result;
    protected long iterations;

    double getResult() {return result;}

    MyThread (long iterations, String name, ThreadGroup tg) {
        super(tg,name);
        this.iterations = iterations;
    }

    @Override
    public void run() {
        double x,y;
        double r;
        int i,j=0;
        int count=0;

        for (i=0; i<iterations; i++) {
            for (j = 0; j < 1000; j++) {
                x = Math.random();
                y = Math.random();

                r = Math.sqrt(x * x + y * y);
                if (r <= 1.0)
                    count++;
            }
        }
        result=count/(double)j;
//        result = 4*count/(double)(iterations*j);
//        System.out.printf("Count is %g, \n", result);
    }
}