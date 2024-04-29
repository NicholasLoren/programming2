package threads;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Thread name: "+ t);
        t.setName("Nicholas Main thread");
        //Print name after rename
        System.out.println("New thread name: "+ t);

        try{
            for (int i = 0; i < 20; i++){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("Something went wrong");
        }
    }
}
