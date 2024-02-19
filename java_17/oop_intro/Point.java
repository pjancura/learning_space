package java_17.oop_intro;

import java.lang.Math;

public class Point {

    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        // returns the distance between 2 points
        return this.distance(0, 0);
    }

    public double distance(Point point) {
        // return distance between the object's point and the argument point
        return this.distance(point.getX(), point.getY());
    }

    public double distance(int x, int y) {
        Point point = new Point(x, y);
        double dist = Math.sqrt(Math.pow((point.getX() - this.getX()), 2) + Math.pow((point.getY() - this.getY()), 2));
        return dist;
    }
    
    public static void main(String[] args) {
        Point p1 = new Point((-1), 1);
        System.out.println(p1.distance(1, -1));

        Point p2 = new Point(-4, 3);
        System.out.println(p2.distance(5, -4));
    }
}
