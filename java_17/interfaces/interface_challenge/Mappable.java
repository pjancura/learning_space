package java_17.interfaces.interface_challenge;

import java.lang.reflect.Field;

import javax.management.RuntimeErrorException;

enum GeometryType {LINE, POLYGON}

enum IconType {CIRCLE, STAR, SQUARE, TRIANGLE}

enum Color {BLACK, BLUE, GREEN, RED}

enum LineMarker {DASHED, DOTTED, SOLID}

public interface Mappable {
    // constant that starts the JSON formatted string
    String JSON_PROPERTY = "\"properties\": {%s\n\t}%n";

    // label: title for the object on the map
    String getLabel();
    // geometry type: a point or line which is what the type will look like on the map
    GeometryType getGeometryType();
    // icon type: a map marker...the shape that is used to represent that type of place on a map
    //      (star, dot, square, red solid line (highways) , blue solid line (rivers))
    String getMarker();
    
    
    // default method toJSON() -> prints the type, label, and geometry type, and iconType in JSON format
    default String toJSON() {
        String propertyString = "\n\t\"mapObjectType\": \"" + this.getClass().getSimpleName() + "\",\n\t\"label\": \"" + 
                                this.getLabel() + "\",\n\t\"GeometryType\": \"" + this.getGeometryType() + "\",\n\t\"iconType\": \"" + 
                                this.getMarker() + "\"";
        return propertyString;
    }


    // static method (Mappable mappable) -> prints the properties for each mappable type, 
    //      including extras that a business class might have
    static void printProperties(Mappable mappable) {

        // needs to collect all fields and put them into a string for the formatted variable
        String stringJSON = mappable.toJSON();
        System.out.printf(JSON_PROPERTY + "\n", stringJSON);
    }

    // was in another student's version of the completed assignment
    //      after reviewing the instructor's version 
    //      I should have overriden the toJSON method at the class level
    // private static void getProperties(Mappable mappable, Field[] fields, StringBuilder stringBuilder) {
    //     stringBuilder.append(String.format("\n\t\"mapObjectType\": \"%s\",", mappable.getClass().getSimpleName()));
    //     for (int i = 0; i < fields.length; i++) {
    //         Field field = fields[i];
    //         // System.out.println(field);
    //         field.setAccessible(true);
    //         try {
    //             if (i > 0) {
    //                 stringBuilder.append(", ");
    //             }
    //             stringBuilder.append("\n\t\"")
    //                     .append(field.getName())
    //                     .append("\": ")
    //                     .append("\"")
    //                     .append(field.get(mappable))
    //                     .append("\"");
 
    //         } catch (IllegalAccessException e) {
    //             throw new RuntimeException(e);
    //         }
    //     }
    //     stringBuilder.append("\n\t");
    // }
}

