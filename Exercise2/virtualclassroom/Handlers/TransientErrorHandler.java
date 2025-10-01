package virtualclassroom.Handlers;



public class TransientErrorHandler {
    public static void retry(Runnable action) {
        int attempts = 3;
        while (attempts-- > 0) {
            try {
                action.run();
                return;
            } catch (Exception e) {
                LoggerUtil.log("Transient error occurred: " + e.getMessage() + ". Retrying...");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignored) {
                }
            }
        }
        LoggerUtil.log("Action failed after retries.");
    }
}
