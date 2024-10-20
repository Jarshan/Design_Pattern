public class Logger {
    // Private static variable to hold the single instance
    private static Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Initialize any resources, e.g., open a file for writing
    }

    // Public method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) { // Double-check locking
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log a message
    public void log(String message) {
        // Implementation to write the message to a file or console
        System.out.println("Log message: " + message);
    }
}


