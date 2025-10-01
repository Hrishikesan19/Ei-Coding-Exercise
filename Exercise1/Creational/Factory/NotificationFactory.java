public class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type.toUpperCase()) {
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAppNotification();
            case "EMAIL":
                return new EmailNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
