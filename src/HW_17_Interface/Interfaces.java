package HW_17_Interface;

public class Interfaces {

    public static void main(String[] args) {
        iPhones iPhone13Mini = new iPhones("13 mini");
        Androids samsungGalaxyA52 = new Androids("Samsung", "Galaxy A52");

        iPhone13Mini.turnPowerOn();
        iPhone13Mini.call();
        iPhone13Mini.sms();
        iPhone13Mini.internet(true);
        iPhone13Mini.internet(false);
        iPhone13Mini.openAppStore();
        iPhone13Mini.turnPowerOff();

        System.out.println();

        samsungGalaxyA52.turnPowerOn();
        samsungGalaxyA52.call();
        samsungGalaxyA52.sms();
        samsungGalaxyA52.internet(true);
        samsungGalaxyA52.internet(false);
        samsungGalaxyA52.openPlayMarket();
        samsungGalaxyA52.turnPowerOff();
    }
}
