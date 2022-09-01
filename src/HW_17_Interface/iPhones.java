package HW_17_Interface;

public class iPhones implements Smartphones, iOS {

    String model;

    iPhones(String model) {
        this.model = model;
    }

    public void turnPowerOn() {
        System.out.println("iPhone " + model);
        System.out.println("Hello!");
    }

    public void turnPowerOff() {
        System.out.println("Goodbye!");
    }

    public void call() {
        System.out.println("Call a contact");
    }

    public void sms() {
        System.out.println("Send sms");
    }

    public void internet(boolean status) {
        System.out.println("LTE " + (status ? "on" : "off"));
    }

    public void openAppStore() {
        System.out.println("Now u can download apps from AppStore");
    }
}
