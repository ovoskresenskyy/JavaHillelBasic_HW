package HW_10_Person;

public class MainApp {
    public static void main(String[] args) {

        System.out.println(personInfo("Will", "Smith", "New York", "2936729462846"));
        System.out.println(personInfo("Jackie", "Chan", "Shanghai", "12312412412"));
        System.out.println(personInfo("Sherlock", "Holmes", "London", "37742123513"));

    }

    private static String personInfo(String name, String surname, String town, String phoneNumber) {
        return "You can call mr. " + name + " " + surname + " from " + town + " at " + phoneNumber + ".";
    }
}
