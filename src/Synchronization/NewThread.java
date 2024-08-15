package Synchronization;

public class NewThread extends Thread{
    private Synchro counter;

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            counter.increment();
        }
    }

    public NewThread(Synchro counter){
        this.counter = counter;
    }
}
