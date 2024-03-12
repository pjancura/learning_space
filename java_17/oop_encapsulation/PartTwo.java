package java_17.oop_encapsulation;

public class PartTwo {
    
    public static void main(String[] args) {
        EncappedPlayer paul = new EncappedPlayer("Paul");

        System.out.println(paul.healthRemaining());
    }
}

class EncappedPlayer {
    private String name;
    private int health;
    private String weapon;

    public EncappedPlayer(String name) {
        this(name, 100, "Sword");
    }

    public EncappedPlayer(String name, int health, String weapon) {
        this.name = name;
        if (health <= 0) {
            this.health = 1;
        } else if (health >= 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public String getWeapon() {
        return weapon;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    public void setName(String name) {
        this.name = name;
    }
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
        if (this.getHealth() >= 100) {
            this.setHealth(100);
            System.out.println(this.getName() + " is at full health.");
        } else {
            System.out.println("Health Remaing: " + this.healthRemaining());
        }
    }

    public int healthRemaining() {
        return this.getHealth();
    }
}

