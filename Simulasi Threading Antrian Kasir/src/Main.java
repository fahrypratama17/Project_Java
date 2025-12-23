public class Main {
    public static void main(String[] args) {
        Thread c1 = new Thread(new CustomerTask("Pelanggan A", 3000));
        Thread c2 = new Thread(new CustomerTask("Pelanggan B", 2000));
        Thread c3 = new Thread(new CustomerTask("Pelanggan C", 1000));

        c1.start();
        c2.start();
        c3.start();

        System.out.println("Semua pelanggan sedang dilayani...");
    }
}