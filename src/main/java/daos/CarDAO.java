package daos;

import java.sql.*;
import java.util.ArrayList;

public class CarDAO extends DAOClass<CarDTO>{

    public CarDTO findById(int id) {
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car WHERE id = " + id );

            if(resultSet.next()) {
                CarDTO car = new CarDTO();

                car.setId(resultSet.getInt("id"));
                car.setMake(resultSet.getString("make"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                car.setYear(resultSet.getInt("year"));
                car.setVin(resultSet.getInt("vin"));

                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<CarDTO> findAll() {
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car");
            ArrayList<CarDTO> list = new ArrayList<CarDTO>();
            while(resultSet.next()) {
                CarDTO car = new CarDTO();

                car.setId(resultSet.getInt("id"));
                car.setMake(resultSet.getString("make"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                car.setYear(resultSet.getInt("year"));
                car.setVin(resultSet.getInt("vin"));

                list.add(car);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(CarDTO dto) {
        Connection conn = ConnectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE car SET make = ?, model = ?, year = ?, color = ?, vin = ? WHERE make = 'SpaceX'");
            preparedStatement.setString(1, dto.getMake());
            preparedStatement.setString(2, dto.getModel());
            preparedStatement.setInt(3, dto.getYear());
            preparedStatement.setString(4, dto.getColor());
            preparedStatement.setInt(5, dto.getVin());

            int i = preparedStatement.executeUpdate();

            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean create(CarDTO dto) {
        Connection conn = ConnectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO car (make, model, year, color, vin) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, dto.getMake());
            preparedStatement.setString(2, dto.getModel());
            preparedStatement.setInt(3, dto.getYear());
            preparedStatement.setString(4, dto.getColor());
            preparedStatement.setInt(5, dto.getVin());

            int i = preparedStatement.executeUpdate();

            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int vin) {
        Connection conn = ConnectionFactory.getConnection();

        try {
            Statement statement = conn.createStatement();
            int i = statement.executeUpdate("DELETE FROM car WHERE vin = " + vin);

            if(i == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
