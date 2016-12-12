import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Алина on 05.12.2016.
 */
public class MyThreadTest {
    private double result;
    private long iterations;
    private final int nt=3;
    private static MyThread p;

    @Before
    public void setUp() throws Exception {
        long iterations=10000;
    }
    @Test
    public void testRun() throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        ThreadGroup tg = new ThreadGroup("main");
        int np = Runtime.getRuntime().availableProcessors();
        int i;

        List<MyThread> threads = new ArrayList<MyThread>();

        p=new MyThread(iterations,"PI"+1, tg);
        i=0;
        while (i<threads.size()) {
            if (tg.activeCount()<np) {
                MyThread t = threads.get(i);
                t.start();
                i++;
            }
        }
        assertEquals(0.0,p.getResult());
    }

    @Test
    public void testGetResult() throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        ThreadGroup tg = new ThreadGroup("main");
        int np = Runtime.getRuntime().availableProcessors();
        int i;

        List<MyThread> threads = new ArrayList<MyThread>();

        p=new MyThread(iterations,"PI"+1, tg);
        i=0;
        while (i<threads.size()) {
            if (tg.activeCount()<np) {
                MyThread t = threads.get(i);
                t.start();
                i++;
                assertTrue(t.getResult() > 0);
            }
        }
    }
}