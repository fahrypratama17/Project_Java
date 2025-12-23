public class CustomerTask implements Runnable{
    private String customerName;
    private int serviceTime;

    public CustomerTask(String customerName, int serviceTime) {
        this.customerName = customerName;
        this.serviceTime = serviceTime;
    }

    @Override
    public void run() {
        System.out.println(customerName + " mulai dilayani");

        try {
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            System.out.println(customerName + " terganggu!");
        }

        System.out.println(customerName + " selesai dilayani");
    }
}