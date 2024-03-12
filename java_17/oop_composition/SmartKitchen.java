package java_17.oop_composition;

public class SmartKitchen {
    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    public void addWater() {
        System.out.println("Adding water to the Coffee Maker...");
        this.brewMaster.brewCoffee();
    }

    public void pourMilk() {
        System.out.println("Pouring milk from the fridge");
        this.iceBox.orderFood();
    }

    public void loadDishwasher() {
        System.out.println("Loading the dish washer...");
        this.dishWasher.doDishes();
    }

    // private void setBrewMaster(CoffeeMaker brewMaster) {
    //     this.brewMaster = brewMaster;
    // }

    // private void setDishWasher(DishWasher dishWasher) {
    //     this.dishWasher = dishWasher;
    // }

    // private void setIceBox(Refrigerator iceBox) {
    //     this.iceBox = iceBox;
    // }

    private boolean getBrewMaster() {
        return this.brewMaster.getHasWorkToDo();
    }

    private boolean getDishWasher() {
        return this.dishWasher.getHasWorkToDo();
    }

    private boolean getIceBox() {
        return this.iceBox.getHasWorkToDo();
    }

    public String getKitchenState() {
        return "CoffeeMaker: " + this.getBrewMaster() + " Dishwasher: " + this.getDishWasher() + " Refrigerator: " + this.getIceBox();
    }


    public void setKitchenState(boolean brewMaster, boolean dishWasher, boolean iceBox) {
        this.brewMaster.setHasWorkToDo(brewMaster);
        this.dishWasher.setHasWorkToDo(dishWasher);
        this.iceBox.setHasWorkToDo(iceBox);
        // System.out.println("New Kitchen State: " + this.getKitchenState());
    }

    public void doKitchenWork() {
        if (this.getBrewMaster() || this.getDishWasher() || this.getIceBox()) {
            System.out.println("\n\nMore Work to Do: \n");
        }
        if (this.getBrewMaster()) {
            this.addWater();
        }
        if (this.getDishWasher()) {
            this.loadDishwasher();
        }
        if (this.getIceBox()) {
            this.pourMilk();
        }
        this.setKitchenState(false, false, false);
    }


    public static void main(String[] args) {
        Refrigerator iceBox = new Refrigerator();
        CoffeeMaker brewMaster = new CoffeeMaker();
        DishWasher dishWasher = new DishWasher();

        System.out.println(iceBox.getHasWorkToDo());
        System.out.println(brewMaster.getHasWorkToDo());
        System.out.println(dishWasher.getHasWorkToDo());

        SmartKitchen smartKitchen = new SmartKitchen(brewMaster, dishWasher, iceBox);

        System.out.println(smartKitchen.getKitchenState());

        smartKitchen.setKitchenState(true, false, false);
        smartKitchen.doKitchenWork();
        smartKitchen.setKitchenState(false, true, false);
        smartKitchen.doKitchenWork();
        smartKitchen.setKitchenState(false, false, true);
        smartKitchen.doKitchenWork();
        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.doKitchenWork();



    }

}

class Refrigerator {
    private boolean hasWorkToDo;

    public Refrigerator() {

    }

    public Refrigerator(boolean hasWorkToDo) {
        this.hasWorkToDo = false;
    }
    
    public boolean getHasWorkToDo() {
        return this.hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood() {
        System.out.println("Ordering Food...");
    }
}

class DishWasher {
    private boolean hasWorkToDo;

    public DishWasher() {

    }

    public DishWasher(boolean hasWorkToDo) {
        this.hasWorkToDo = false;
    }

    public boolean getHasWorkToDo() {
        return this.hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes() {
        System.out.println("Doin' the dishes...");
    }
}

class CoffeeMaker {
    private boolean hasWorkToDo;

    public CoffeeMaker(){

    }

    public CoffeeMaker(boolean hasWorkToDo) {
        this.hasWorkToDo = false;
    }

    public boolean getHasWorkToDo() {
        return this.hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void brewCoffee() {
        System.out.println("Brewing some java...");
    }
}