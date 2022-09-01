package HW_5_Dynasty;

public class MainApp {
    public static void main(String[] args) {

        // Li Dynasty
        int attack_Warrior_LiDynasty    = 13;
        int attack_Archer_LiDynasty     = 24;
        int attack_Rider_LiDynasty      = 13;
        int quantity_AnyType_LiDynasty  = 860;

        int attack_AllWarriors_LiDynasty = Math.multiplyExact(attack_Warrior_LiDynasty, quantity_AnyType_LiDynasty);
        int attack_AllArchers_LiDynasty  = Math.multiplyExact(attack_Archer_LiDynasty, quantity_AnyType_LiDynasty);
        int attack_AllRiders_LiDynasty   = Math.multiplyExact(attack_Rider_LiDynasty, quantity_AnyType_LiDynasty);
        int generalAttack_LiDynasty      = attack_AllWarriors_LiDynasty + attack_AllArchers_LiDynasty + attack_AllRiders_LiDynasty;

        System.out.println("General attack Li Dynasty: " + generalAttack_LiDynasty);

        // Min Dynasty
        int attack_Warrior_MinDynasty   = 9;
        int attack_Archer_MinDynasty    = 35;
        int attack_Rider_MinDynasty     = 12;
        double generalAttack_MinDynasty = (attack_Warrior_MinDynasty + attack_Archer_MinDynasty + attack_Rider_MinDynasty) * quantity_AnyType_LiDynasty * 1.5;

        System.out.println("General attack Min Dynasty: " + generalAttack_MinDynasty);
    }
}

