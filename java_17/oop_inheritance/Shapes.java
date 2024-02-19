package java_17.oop_inheritance;

public class Shapes {
    

    class Rectangle {
        private double width;
        private double length;

        public Rectangle(double width, double length) {
            this.width = (width < 0) ? 0 : width;
            this.length = (length < 0) ? 0 : length;
        }

        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        public double getArea() {
            return this.length * this.width;
        }
    }

    class Cuboid extends Rectangle {
        private double height;

        public Cuboid(double width, double length, double height) {
            super(width, length);
            this.height = (height < 0) ? 0 : height;
        }

        public double getHeight() {
            return height;
        }

        public double getVolume() {
            return this.getArea() * this.getHeight();
        }
    }
}
