package threads;

public class ThreadDemo2 {

    static class CallMe{
        synchronized void call(String msg){
            System.out.print("[ "+msg);

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e) { System.out.println("Interrupted"); }
            System.out.print(" ] \n");
        }
    }

    static class Caller implements Runnable{
        Thread t;
        CallMe target;
        String msg;

        Caller(CallMe target, String msg){
            this.target = target;
            this.msg = msg;
             t = new Thread(this);
             t.start();
        }

        public void run(){
            target.call(msg);
        }
    }

    public static void main(String[] args) {
        CallMe target = new CallMe();

        Caller obj1 = new Caller(target,"Hello");
        Caller obj2 = new Caller(target,"Synchronized");
        Caller obj3 = new Caller(target,"World");

        try{
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        }catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
