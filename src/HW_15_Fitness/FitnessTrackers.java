package HW_15_Fitness;

interface fitnessTrackers {

    String getName();

    String getEmail();

    int getAge();

    String getPhoneNumber();

    String getBrand();

    void setSurName(String surName);

    void setWeight(int weight);

    void setPressure(int pressureUp, int pressureDown);

    void setStepsPerDay(int stepsPerDay);

    void printAccountInfo();
}

abstract class baseChinaFitnessTracker implements fitnessTrackers {
    private String name, email, phoneNumber, brand;
    private int age;
    protected int day, month, year;

    protected String surName;
    protected int weight, pressureUp, pressureDown, stepsPerDay;

    public baseChinaFitnessTracker(String name,
                                   String surName,
                                   String email,
                                   String phoneNumber,
                                   String brand,
                                   int birthDay,
                                   int birthMonth,
                                   int birthYear,
                                   int weight,
                                   int pressureUp,
                                   int pressureDown,
                                   int stepsPerDay) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.brand = brand;
        this.day = birthDay;
        this.month = birthMonth;
        this.year = birthYear;
        this.age = 2022 - birthYear;
        this.weight = weight;
        this.pressureUp = pressureUp;
        this.pressureDown = pressureDown;
        this.stepsPerDay = stepsPerDay;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPressure(int pressureUp, int pressureDown) {
        this.pressureUp = pressureUp;
        this.pressureDown = pressureDown;
    }

    public void setStepsPerDay(int stepsPerDay) {
        this.stepsPerDay = stepsPerDay;
    }

    public void printAccountInfo() {
        String AccountInfo = "Account info of " + getBrand() + " fitness tracker:\n"
                + "Name: " + getName() + "\n"
                + "Surname: " + surName + "\n"
                + "Age: " + getAge() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Phone number: " + getPhoneNumber() + "\n"
                + "Weight: " + weight + "\n"
                + "Pressure: " + pressureUp + "/" + pressureDown + "\n"
                + "Steps per day: " + stepsPerDay + "\n";

        System.out.println(AccountInfo);
    }

}

class fitnessTrackerXiaomi extends baseChinaFitnessTracker {

    public fitnessTrackerXiaomi(String name,
                                String surName,
                                String email,
                                String phoneNumber,
                                int birthDay,
                                int birthMonth,
                                int birthYear,
                                int weight,
                                int pressureUp,
                                int pressureDown,
                                int stepsPerDay) {
        super(name,
                surName,
                email,
                phoneNumber,
                "Xiaomi",
                birthDay,
                birthMonth,
                birthYear,
                weight,
                pressureUp,
                pressureDown,
                stepsPerDay);
    }

    @Override
    public void printAccountInfo() {

        String AccountInfo = "-----------------------------\n"
                + "Xiaomi fitness tracker welcomes you!" + "\n"
                + "Hello " + getName() + " " + surName + "\n"
                + "Phone number: " + getPhoneNumber() + "\n"
                + "Email: " + getEmail() + "\n" + "\n"
                + "You are " + getAge() + " years old\n"
                + "Your weight is " + weight + " kg\n"
                + "Blood pressure " + pressureUp + "/" + pressureDown + " mm Hg\n"
                + "You walk " + stepsPerDay + " steps per day\n"
                + healthCheck(getAge()) + "\n"
                + "-----------------------------\n";

        System.out.println(AccountInfo);
    }

    private String healthCheck(int age) {
        if (age < 16) {
            return "You're too young, it's too early to check your blood pressure.";
        } else if ((age < 20 && (pressureUp < 100 || pressureUp > 120 || pressureDown < 70 || pressureDown > 80))
                || (age >= 20 && age < 40 && (pressureUp < 120 || pressureUp > 130 || pressureDown < 70 || pressureDown > 80))
                || (age >= 40 && age < 60 && (pressureUp > 140 || pressureDown > 90))
                || (age >= 60 && (pressureUp > 150 || pressureDown > 90))) {
            return "You have problems with blood pressure. Take care of your health.";
        } else {
            return "Your blood pressure is good";
        }
    }
}

class fitnessTrackerHuawei extends baseChinaFitnessTracker {

    protected int height;

    public fitnessTrackerHuawei(String name,
                                String surName,
                                String email,
                                String phoneNumber,
                                int birthDay,
                                int birthMonth,
                                int birthYear,
                                int weight,
                                int height,
                                int pressureUp,
                                int pressureDown,
                                int stepsPerDay) {
        super(name,
                surName,
                email,
                phoneNumber,
                "Huawei",
                birthDay,
                birthMonth,
                birthYear,
                weight,
                pressureUp,
                pressureDown,
                stepsPerDay);

        this.height = height;
    }

    @Override
    public void printAccountInfo() {

        String AccountInfo = "Huawei (o_O)\n"
                + "Hello " + getName() + " " + surName + "\n"
                + "Phone: +38" + getPhoneNumber() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Age: " + getAge() + " years old\n"
                + "Weight: " + weight + " kg\n"
                + "Height: " + height + " cm\n"
                + weightCheck() + "\n"
                + "Blood pressure: " + pressureUp + "/" + pressureDown + " mm Hg\n"
                + "Steps per day: " + stepsPerDay + "\n"
                + "(o_O)\n";

        System.out.println(AccountInfo);
    }

    private String weightCheck() {

        int coefficient;

        if (height < 150) {
            coefficient = 100;
        } else if (height < 175) {
            coefficient = 105;
        } else coefficient = 110;

        int normalWeight = height - coefficient;

        if (weight == normalWeight-1 || weight == normalWeight || weight == normalWeight+1) {
            return "Your weight is good!";
        } else if (weight < normalWeight-1) {
            return "Your weight is below normal!";
        } else return "Your weight is overweight. Recommended to walk more";
    }
}

class fitnessTrackerNoName extends baseChinaFitnessTracker {

    public fitnessTrackerNoName(String name,
                                String surName,
                                String email,
                                String phoneNumber,
                                int birthDay,
                                int birthMonth,
                                int birthYear,
                                int weight,
                                int pressureUp,
                                int pressureDown,
                                int stepsPerDay) {
        super(name,
                surName,
                email,
                phoneNumber,
                "No name",
                birthDay,
                birthMonth,
                birthYear,
                weight,
                pressureUp,
                pressureDown,
                stepsPerDay);
    }
}

