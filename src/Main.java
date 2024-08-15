class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.start();
        Test2 test2 = new Test2();
        Thread thread = new Thread(test2);
        thread.start();
        for(int i=0;i<100000;i++) {
            System.out.println("Hello "+Thread.currentThread().getName());
        }
        }
    }