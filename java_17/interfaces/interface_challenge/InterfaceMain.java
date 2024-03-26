package java_17.interfaces.interface_challenge;

public class InterfaceMain {
    
    public static void main(String[] args) {
        River cuyahogaRiver = new River("Cuyahoga River");
        Mappable.printProperties(cuyahogaRiver);
        
        Building cityHall = new Building("City Hall", UsageType.GOVERNMENT);
        Mappable.printProperties(cityHall);
    }
}
