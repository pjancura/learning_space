// encapsulation hides things away from the user
//      it makes in the interface simpler
//      protect the integrity of data on an object
//          by hiding or restricting accesss to some of the data and operations
//      decouple the published interface from the internal details of the class
//          we may hide the actual names and types of class members

//   Encapsulation helps with code maintenance
//      if changes were made in the class you may not necessarily have to change code in other places
//      by having a constructor...it helps ensure that objects are created correctly


package java_17.oop_encapsulation;

public class PartOne {
    
    public static void main(String[] args) {
        Player player = new Player();
        player.fullName = "Time";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        player.healthRemaining();

        player.loseHealth(damage);
        player.healthRemaining();
    }
}

// this has examples of not using encapsulation
// PartTwo.java will fix these issues;
class Player {
    public String fullName;
    public int health;
    public String weapon;

    // public Player(String name, int health, String weapon) {
    //     this.name = name;
    //     this.health = health;
    //     this.weapon = weapon;
    // }

    public int getHealth() {
        return health;
    }
    // public String getName() {
    //     return name;
    // }
    public String getWeapon() {
        return weapon;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    // public void setName(String name) {
    //     this.name = name;
    // }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.health = this.getHealth() - damage;
        if (this.health <= 0) {
            System.out.println("Player KO'd");
        } else {
            System.out.println("Health Remaing: " + this.healthRemaining());
        }
    }

    public void restoreHealth(int extraHealth) {
        this.setHealth(extraHealth + this.getHealth());
        // if (this.getHealth() >= 100) {
        //     this.setHealth(100);
        //     System.out.println(this.getName() + " is at full health.");
        // } else {
        //     System.out.println("Health Remaing: " + this.healthRemaining());
        // }
    }

    public int healthRemaining() {
        return this.getHealth();
    }
}
