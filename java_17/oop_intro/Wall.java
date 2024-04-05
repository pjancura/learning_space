package java_17.oop_intro;

public class Wall {

    private double width;
    private double height;

    public Wall() {
        this(0, 0);
    }

    public Wall(double width, double height) {
        this.width = width;
        if (width < 0) {
            this.width = 0;
        }
        this.height = height;
        if (height < 0) {
            this.height = 0;
        }
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
        if (height < 0) {
            this.height = 0;
        }
    }   

    public void setWidth(double width) {
        this.width = width;
        if (width < 0) {
            this.width = 0;
        }
    }

    public double getArea() {
        return this.width * this.height;
    }

}
