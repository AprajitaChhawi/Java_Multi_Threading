package Thread_Communication;

class SharedResource{
    private int data;
    public boolean hasdata;

    public synchronized void produce(int value){
        while(hasdata){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasdata = true;
        System.out.println("produced "+value);
        notify();
    }
    public synchronized int consume(){
        while(!hasdata){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasdata = false;
        System.out.println("consumed "+data);
        notify();
        return data;
    }
}

class Producer implements Runnable{
    private SharedResource resource;
    public Producer(SharedResource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private SharedResource resource;
    public Consumer(SharedResource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            int data = resource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        Thread producer = new Thread(new Producer(resource1));
        Thread consumer = new Thread(new Consumer(resource1));
        producer.start();
        consumer.start();
    }
}
