public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification n1 = factory.createNotification("SMS");
        n1.notifyUser();

        Notification n2 = factory.createNotification("WHATSAPP");
        n2.notifyUser();

        Notification n3 = factory.createNotification("EMAIL");
        n3.notifyUser();
    }
}
