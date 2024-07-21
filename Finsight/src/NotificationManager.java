import java.util.List;

public class NotificationManager {
    public List<String> generateNotifications(List<String> triggerEvents) {
        // For simplicity, let's assume each trigger event corresponds to a notification message
        return triggerEvents;
    }

    public void deliverNotifications(List<String> notifications) {
        // For simplicity, let's just print out each notification message
        for (String notification : notifications) {
            System.out.println("Notification: " + notification);
        }
    }
}
