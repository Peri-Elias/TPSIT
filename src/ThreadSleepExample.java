public class ThreadSleepExample extends Thread{
    //attributi
    private int sleepTime;
    private ThreadSleepExample [] threadChild;
    private int numChild;
    //constructor
    public ThreadSleepExample(int sleepTime, int numChild){
        this.sleepTime = sleepTime;
        this.numChild = numChild;
        if(numChild > 0){
            threadChild = new ThreadSleepExample[numChild];
        }
    }

    @Override
    public void run(){
        for(int i = 0; i < numChild; i++){
            threadChild[i] = new ThreadSleepExample(sleepTime/3, 0);
            threadChild[i].start();
        }//for each child
        for (int i = 0; i < 10; i++){
            if(Thread.currentThread().isDaemon()){
                break;
            }
            try {
                Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                break;
            }
        }//for main thread

        for(int i = 0; i <numChild; i++){
            if(threadChild[i]!= null){
                threadChild[i].interrupt();
            }

        }
        for(int i = 0; i <numChild; i++){
            try {
                if(threadChild[i]!= null){
                    threadChild[i].join();
                }
            }catch (InterruptedException e){
                break;
            }
        }
    }
}
