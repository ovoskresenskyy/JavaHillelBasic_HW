package HW_17_Interface;

public class Androids implements Smartphones, LinuxOS {

    String manufacturer, model;

    Androids(String manufacturer, String model) {
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public void turnPowerOn() {
        System.out.println(manufacturer + " " + model);
        System.out.println("Welcome!");
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

    public void openPlayMarket() {
        System.out.println("Now u can download apps from Play Market");
    }
}
