package java_17.interfaces.exercise_forty_eight;

import java.util.Arrays;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    // getter and setters
    public int getHitPoints() {
        return hitPoints;
    }
    public String getName() {
        return name;
    }
    public int getStrength() {
        return strength;
    }

    // interface methods
    @Override
    public List<String> write() {
        return Arrays.asList(this.name, String.valueOf(this.hitPoints), String.valueOf(this.strength));
    }

    @Override
    public void read(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.name = list.get(0);
        this.hitPoints = Integer.parseInt(list.get(1));
        this.strength = Integer.parseInt(list.get(2));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{name=\'" + this.getName() + "\', hitPoints=" + 
                this.getHitPoints() + ", strength=" + this.getStrength() + "}";
    }
}
