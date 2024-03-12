package java_17.oop_intro;


public class Floor {
    private double width;
    private double length;

    public Floor(double width, double length) {
        this.width = width;
        if (width < 0) {
            this.width = 0;
        }
        this.length = length;
        if (length < 0) {
            this.length = 0;
        }
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return this.getLength() * this.getWidth();
    }



}