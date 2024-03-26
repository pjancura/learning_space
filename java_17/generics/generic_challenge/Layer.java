package java_17.generics.generic_challenge;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private List<T> locations;

    public Layer() {
        this.locations = new ArrayList<T>();
    }

    public Layer(List<T> locations) {
        this.locations = locations;
    }

    public void addLocation(T t) {
        this.locations.add(t);
    }

    public void addLocations(ArrayList<T> t) {
        for (T element : t) {
            this.locations.add(element);
        }
    }

    public void renderLayer() {
        for (T t : this.locations) {
            t.render();
        }
    }
}
