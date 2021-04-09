package daos;

import java.util.ArrayList;

public class MainApplication {

    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();
        CarDTO carMars = new CarDTO("SpaceX", "MarsRover", 4550, "Steel", 99999);
        CarDTO carJupiter = new CarDTO("SpaceX", "JupiterRover", 5000, "Gradient", 99999);

        CarDTO carOne = carDAO.findById(1);
        System.out.println("This is the card with ID: 1");
        System.out.println(carOne);

        ArrayList<CarDTO> carList = carDAO.findAll();
        System.out.println("This is the whole car inventory");
        for(CarDTO car : carList) {
            System.out.println(car);
        }

        carDAO.create(carMars);
        System.out.println("\nThis new car have been added to the inventory");
        System.out.println(carMars);
        ArrayList<CarDTO> carListUpdate = carDAO.findAll();
        System.out.println("This is the whole car inventory\n");
        for(CarDTO car : carListUpdate) {
            System.out.println(car);
        }

        carDAO.update(carJupiter);
        System.out.println("\nUpdated SpaceX car to new model");
        System.out.println(carJupiter);

        ArrayList<CarDTO> carListUpdate2 = carDAO.findAll();
        System.out.println("This is the whole car inventory\n");
        for(CarDTO car : carListUpdate2) {
            System.out.println(car);
        }

        carDAO.delete(99999);
        System.out.println("\nSpaceX cars have been sold out!");
        ArrayList<CarDTO> carListUpdate3 = carDAO.findAll();
        System.out.println("This is the whole car inventory\n");
        for(CarDTO car : carListUpdate3) {
            System.out.println(car);
        }
    }
}
