
public class Main {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("photo1.jpg");
        Image img2 = new ProxyImage("photo2.jpg");

        System.out.println("Images created, but not loaded yet.");

        img1.display();  // load
        img1.display();  // cached, no reload
        img2.display(); 
    }
}
