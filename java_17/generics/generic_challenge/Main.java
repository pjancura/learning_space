package java_17.generics.generic_challenge;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Double> cuyCoords = List.of(41.29227627493205, -81.56597030531744);
        NationalPark cuyahogaNationalPark = new NationalPark("Cuyahoga National Park", cuyCoords);
        NationalPark yosemite = new NationalPark("Yosemite", List.of(37.891875480986826, -119.53330976238364));


        List<List<Double>> cuyRiverCoords = List.of(List.of(41.29227627493205, -81.56597030531744), List.of(41.31990505142011, -81.58757464568345), List.of(41.45400853807623, -81.6839410534267), List.of(41.49905536071782, -81.70726554175151));
        River cuyahogaRiver = new River("Cuyahoga River", cuyRiverCoords);

        Layer<Point> layerPoints = new Layer<Point>();
        layerPoints.addLocation(cuyahogaNationalPark);
        layerPoints.addLocation(yosemite);
        layerPoints.renderLayer();

        Layer<Line> layerLines = new Layer<Line>();
        layerLines.addLocation(cuyahogaRiver);
        layerLines.renderLayer();


    }
}
