package DF1;
/**
 * This class demonstrates basic exception handling in Java. It simulates sending a message
 * and handles the case where the recipient is offline.
 */
public class ExceptionsHandling {
    public static void main(String[] args) {
        // Create a new user
        User user1 = new User("Alice", true);
        User user2 = new User("Bob", false);

        // Create a message app
        MessageApp messageApp = new MessageApp();

        // Send a message to the recipient
        try {
            messageApp.sendMessage("Hello, Bob!", user2);
        } catch (RecipientOfflineException e) {
            System.out.println("Recipient is offline. Message not sent.");
        }
    }
    /**
     * This class represents a simple message application.
     */
    static class MessageApp {
        /**
         * Sends a message to a recipient.
         *
         * @param message The message to send.
         * @param recipient The recipient of the message.
         * @throws RecipientOfflineException If the recipient is offline.
         */
        public void sendMessage(String message, User recipient) throws RecipientOfflineException {
            // Logic to simulate sending the message
            Message messageObj = new Message();
            messageObj.send(message, recipient);  // This line can throw RecipientOfflineException
        }
    }
    /**
     * This class represents a user with a username and online status.
     */
    static class User {
        private final String username;
        private boolean isOnline;
        /**
         * Creates a new User object.
         *
         * @param username The username of the user.
         * @param isOnline Whether the user is online.
         */
        User(String username, boolean isOnline) {
            this.username = username;
            this.isOnline = isOnline;
        }

        public void setIsOnline(boolean status) {
            this.isOnline = status;
        }

        public boolean getIsOnline() {
            return this.isOnline;
        }

        public String getUsername() {
            return username;
        }
    }
    /**
     * This class represents a message object with a method to send the message.
     */
    static class Message {
        /**
         * Sends a message to a recipient. Throws an exception if the recipient is offline.
         *
         * @param message The message to send.
         * @param recipient The recipient of the message.
         * @throws RecipientOfflineException If the recipient is offline.
         */
        public void send(String message, User recipient) throws RecipientOfflineException {
            if (!recipient.getIsOnline()) throw new RecipientOfflineException();
            // Logic to send the message (simulate here)
            System.out.println("Sending message: " + message + " to " + recipient.getUsername());
        }
    }
    /**
     * This class represents an exception thrown when the recipient of a message is offline.
     */
    static class RecipientOfflineException extends Exception {
        public RecipientOfflineException() {
            super("Recipient is offline");
        }
    }
}
