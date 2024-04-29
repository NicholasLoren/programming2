package threads;

public class ProducerConsumerSolution {
    static class Q {
        int n;
        boolean valueSet = false;
        synchronized void put(int n) {

            while(valueSet)
                try{
                    wait();
                }catch(InterruptedException e){
                    System.out.println("Interrupted");
                }
            this.n = n;
            valueSet = true;
            System.out.println("Put: " + n);
            notify();
        }

        synchronized int get() {
            while(!valueSet)
                try{
                    wait();
                }catch(InterruptedException e){
                    System.out.println("Interrupted");
                }
            System.out.println("Got: " + this.n);
            valueSet = false;
            notify();
            return this.n;
        }

    }

    static class Producer implements Runnable {
        Q q;

        Producer(Q q) {
            this.q = q;
            new Thread(this, "Producer").start();
        }

        public void run() {
            int n = 0;
            while (true) {
                q.put(n++);
            }
        }
    }

    static class Consumer implements Runnable {
        Q q;

        Consumer(Q q) {
            this.q = q;
            new Thread(this, "Consumer").start();
        }

        public void run() {
            while(true){ q.get(); }
        }
    }

    public static void main(String[] args) {
        Q q = new Q();

        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
    }
}
