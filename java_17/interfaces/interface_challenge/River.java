package java_17.interfaces.interface_challenge;



public class River implements Mappable {
    private String label;


    public River(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public GeometryType getGeometryType() {
        return GeometryType.LINE;
    }

    @Override
    public String getMarker() {
        return LineMarker.SOLID + " " + Color.BLUE;
    }


}
