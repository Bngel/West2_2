import com.sun.org.apache.xpath.internal.operations.Plus;

import java.util.ArrayList;
import java.util.Scanner;

public class PlusPart implements Runnable{
    static long ans = 0;

    private Thread thread;
    private int start;
    private int end;
    private int x;
    private String threadName;

    PlusPart(int start,int end, int x,String name) {
        this.start = start;
        this.end = end;
        threadName = name;
        this.x = x;
        ans = 0;
    }

    @Override
    public void run() {
        for (int i=start;i<end;i++)
            if (contain(i,x))
                ans += i;
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }

    public static void main(String[] args) {
        ArrayList<PlusPart> plusParts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        for (int i=0;i<1000000001;i+=1000000)
            plusParts.add(new PlusPart(i,i+1000000,x,String.format("thread%d",i)));
        for (PlusPart p: plusParts) {
            p.start();
            System.out.println("Thread:"+ p.threadName + " start");
        }
        if (x == 0 || x == 1) {
            ans -= 1000000000;
        }
        System.out.println(ans);
    }
}
