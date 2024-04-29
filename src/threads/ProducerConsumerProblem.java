package threads;

public class ProducerConsumerProblem {
    static class Q {
        int n;

        synchronized void put(int n) {
            System.out.println("Put: " + n);
            this.n = n;
        }

        int get() {
            System.out.println("Got: " + this.n);
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
            while(true){ this.q.get(); }
        }
    }

    public static void main(String[] args) {
        Q q = new Q();

        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
    }
}
