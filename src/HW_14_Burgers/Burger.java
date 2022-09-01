package HW_14_Burgers;

class Burger {

    String name, bunType;
    int cutlet, cheese;
    boolean greens, mayonnaise;

    Burger() {
        this("Classic", "classic", 1, 1, true, true);
    }

    Burger(String name, String bunType, int cutlet, int cheese, boolean greens, boolean mayonnaise) {
        this.name = name;
        this.bunType = bunType;
        this.cutlet = cutlet;
        this.cheese = cheese;
        this.greens = greens;
        this.mayonnaise = mayonnaise;

        printIngredients();
    }

    void printIngredients() {

        String ingredients = "Here's your " + name + " burger.\nIncluding:\n"
                + "- " + bunType + " bun\n"
                + "- " + (cutlet == 2 ? "double " : "") + "cutlet\n"
                + "- " + (cheese == 2 ? "double " : "") + "cheese\n"
                + (greens ? "- greens\n" : "")
                + (mayonnaise ? "- mayonnaise\n" : "")
                + "Enjoy!\n";

        System.out.println(ingredients);
    }
}

class DietBurger extends Burger {
    DietBurger() {
        super("Dietary", "whole grain", 1, 1, true, false);
    }
}

class DoubleMeatBurger extends Burger {
    DoubleMeatBurger() {
        super("Double meat", "classic", 2, 2, true, true);
    }
}

