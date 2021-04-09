package daos;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;

public class CarDAOTest extends TestCase {

    public void testFindByIdMake() {
        //Given:
        CarDAO carDAO = new CarDAO();

        //When:
        CarDTO test = carDAO.findById(1);
        String expected = "hyundai";
        String actual = test.getMake();

        //Then:
        Assert.assertEquals(expected, actual);
    }

    public void testFindByIdModel() {
        //Given:
        CarDAO carDAO = new CarDAO();

        //When:
        CarDTO test = carDAO.findById(2);
        String expected = "accord";
        String actual = test.getModel();

        //Then:
        Assert.assertEquals(expected, actual);
    }

    public void testFindByIdYear() {
        //Given:
        CarDAO carDAO = new CarDAO();

        //When:
        CarDTO test = carDAO.findById(3);
        int expected = 2019;
        int actual = test.getYear();

        //Then:
        Assert.assertEquals(expected, actual);
    }

    public void testFindByIdColor() {
        //Given:
        CarDAO carDAO = new CarDAO();

        //When:
        CarDTO test = carDAO.findById(4);
        String expected = "green";
        String actual = test.getColor();

        //Then:
        Assert.assertEquals(expected, actual);
    }

    public void testFindAll() {
        //Given:
        CarDAO carDAO = new CarDAO();

        //When:
        ArrayList<CarDTO> carList = carDAO.findAll();

        //Then:
        Assert.assertFalse(carList.isEmpty());
    }

    public void testCreate() {
        //Given:
        CarDAO carDAO = new CarDAO();
        CarDTO car = new CarDTO("SpaceX", "JupiterRover", 4550, "Steel", 99999);

        //When:
        carDAO.create(car);
        ArrayList<CarDTO> carList = carDAO.findAll();
        String expected = "JupiterRover";
        String actual = carList.get(carList.size()-1).getModel();

        //Then:
        Assert.assertEquals(expected, actual);
    }

    public void testUpdate() {
        //Given:
        CarDAO carDAO = new CarDAO();
        CarDTO car = new CarDTO("test", "one", 1, "fake", 99999);

        //When:
        carDAO.update(car);
        ArrayList<CarDTO> carList = carDAO.findAll();
        String expected = "one";
        String actual = carList.get(carList.size()-1).getModel();

        //Then:
        Assert.assertEquals(expected, actual);
    }

    public void testDelete() {
        //Given:
        CarDAO carDAO = new CarDAO();

        //When:
        carDAO.delete(99999);
        ArrayList<CarDTO> carList = carDAO.findAll();
        String expected = "three";
        String actual = carList.get(carList.size()-1).getModel();

        //Then:
        Assert.assertEquals(expected, actual);
    }
}