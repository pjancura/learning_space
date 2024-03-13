package java_17.interfaces.exercise_forty_eight;

import java.util.Arrays;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
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
    public String getWeapon() {
        return weapon;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    // interface methods
    @Override
    public List<String> write() {
        return Arrays.asList(this.name, String.valueOf(this.hitPoints), String.valueOf(this.strength), this.weapon);
    }

    @Override
    public void read(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.setName(list.get(0));
        this.setHitPoints(Integer.parseInt(list.get(1)));
        this.setStrength(Integer.parseInt(list.get(2)));
        this.setWeapon(list.get(3));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{name=\'" + this.getName() + "\', hitPoints=" + 
                this.getHitPoints() + ", strength=" + this.getStrength() + ", weapon=\'" + this.getWeapon() + "\'}";
    }
}
