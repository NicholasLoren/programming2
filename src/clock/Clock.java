package clock;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * The Clock class represents a simple clock application that continuously updates and prints the current time and date.
 * This class utilizes Java threads to handle background updating and display of time.
 */
public class Clock {

    private volatile boolean running; // Flag to control clock running state

    /**
     * Constructs a new Clock object.
     * Initializes the clock as running.
     */
    public Clock() {
        this.running = true;
    }

    /**
     * Starts the clock by creating and starting two threads:
     * 1. Background thread for updating time every second.
     * 2. Display thread for printing time to the console.
     * Background updating thread has lower priority than display thread.
     */
    public void startClock() {
        // Background thread for updating time
        Thread updateTimeThread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(1000); // Update time every second
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        });
        updateTimeThread.setPriority(Thread.MIN_PRIORITY); // Lower priority for background updating

        // Display thread for printing time to console
        Thread displayTimeThread = new Thread(() -> {
            while (running) {
                printCurrentTime();
                try {
                    Thread.sleep(1000); // Print time every second
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        });
        displayTimeThread.setPriority(Thread.MAX_PRIORITY); // Higher priority for display

        // Start threads
        updateTimeThread.start();
        displayTimeThread.start();
    }

    /**
     * Stops the clock by setting the running flag to false.
     * Both threads will terminate their execution.
     */
    public void stopClock() {
        running = false;
    }

    /**
     * Prints the current time and date to the console in the format "HH:mm:ss dd-MM-yyyy".
     */
    private void printCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        Calendar now = Calendar.getInstance();
        System.out.println(dateFormat.format(now.getTime()));
    }

    /**
     * Entry point of the Clock application.
     * Creates a Clock object and starts the clock.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.startClock();
    }
}
