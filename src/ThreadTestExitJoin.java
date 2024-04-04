import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadTestExitJoin {
    public static void main(String [] args) throws IOException {
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Sleep time:");
        int sleepTm = Integer.parseInt( tastiera.readLine());
        System.out.println("numero figli:");
        int numFigli = Integer.parseInt( tastiera.readLine());
        ThreadSleepExample mainThread = new ThreadSleepExample(sleepTm,numFigli );
        mainThread.run();
        mainThread.interrupt();
        try {
            mainThread.join();
        }catch (InterruptedException e){
            System.err.println("Main thread interrotto");
        }
        System.exit(0);
    }
}
