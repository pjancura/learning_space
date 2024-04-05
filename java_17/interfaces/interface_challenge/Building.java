package java_17.interfaces.interface_challenge;

enum UsageType {ENTERTAINMENT, BUSINESS, GOVERNMENT, RESIDENTIAL, SPORTS}

public class Building implements Mappable {
    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return this.name;
    }

    @Override
    public GeometryType getGeometryType() {
        return GeometryType.POLYGON;
    }

    @Override
    public String getMarker() {
        return switch(this.usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + IconType.STAR;
            case BUSINESS -> Color.BLUE + " " + IconType.STAR;
            case GOVERNMENT -> Color.BLACK + " " + IconType.STAR; 
            case RESIDENTIAL -> Color.RED + " " + IconType.TRIANGLE;
            case SPORTS -> Color.BLUE + " " + IconType.SQUARE;
            default -> Color.BLACK + " " + IconType.CIRCLE;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON().concat(",").concat("\n\t\"usage\": \"" + String.valueOf(this.usage) + "\"");
    }
}
