import java.util.ArrayList;
import java.util.Scanner;

public class PlusPart implements Runnable{
    static ArrayList<PlusPart> plusParts = new ArrayList<>();

    private Thread thread;
    private long start;
    private long end;
    private int x;
    private String threadName;
    private long ans;

    PlusPart(long start,long end, int x,String name) {
        this.start = start;
        this.end = end;
        threadName = name;
        this.x = x;
        this.ans = 0;
    }

    public long getAns() {
        return ans;
    }

    @Override
    public void run() {
        for (long i=start;i<end;i++)
            if (contain(i,x)) {
                ans += i;
            }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    public boolean isAlive(){
        return thread.isAlive();
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }

    private static boolean isFinished() {
        for (PlusPart p: plusParts) {
            if (p.isAlive()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long ans = 0;
        for (long i=0;i<1000000001;i+=100000)
            plusParts.add(new PlusPart(i,i+100000,x,String.format("thread%d",i)));
        for (PlusPart p: plusParts) {
            p.start();
            System.out.println("Thread:"+ p.threadName + " start");
        }
        while(!isFinished());
        for (PlusPart p: plusParts) {
            ans += p.getAns();
        }
        if (x == 0 || x == 1)
            ans -= 1000000000;
        System.out.println(ans);
    }
}