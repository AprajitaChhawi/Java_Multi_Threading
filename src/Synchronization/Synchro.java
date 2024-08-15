package Synchronization;

public class Synchro {
    private int counter =0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment(){
        synchronized (Synchro.class){ //we can use this also
            counter=counter+1; //critical section , race condition , mutual exclusion
        }
    }
}
