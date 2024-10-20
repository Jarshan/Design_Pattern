public class Main {
    public static void main(String[] args) {
        // Obtain the single instance of Logger
        Logger logger = Logger.getInstance();

        // Log some messages
        logger.log("This is the first log message.");
        logger.log("This is the second log message.");
    }
}
