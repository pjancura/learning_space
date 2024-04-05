package java_17.generics.generic_challenge;

import java.lang.reflect.Array;
import java.util.List;



public interface Mappable {
    void render();
}

class Line implements Mappable {
    private String name;
    private List<List<Double>> coords;

    public Line(String name, List<List<Double>> coords) {
        this.name = name;
        this.coords = coords;
    }

    private String location() {
        return "Render " + this.name + " as LINE "  + "(" + this.coords + ")";

    }

    @Override 
    public void render() {
        System.out.println(this.location());
    }
}

class Point implements Mappable {
    private String name;
    private List<Double> coords;

    public Point(String name, List<Double> coords) {
        this.name = name;
        this.coords = coords;
    }

    private String location() {
        return "Render " + this.name + " as POINT " + "(" + this.coords + ")";
    }
    @Override
    public void render() {
        System.out.println(this.location());
    }
}

class NationalPark extends Point {
    public NationalPark(String name, List<Double> coords) {
        super(name, coords);
    }
}

class River extends Line {
    public River(String name, List<List<Double>> coords) {
        super(name, coords);
    }
}