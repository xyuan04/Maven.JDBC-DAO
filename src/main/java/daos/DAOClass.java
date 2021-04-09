package daos;

import java.util.ArrayList;

public abstract class DAOClass<T>{

    public abstract T findById(int id);

    public abstract ArrayList<T> findAll();

    public abstract boolean update(T dto);

    public abstract boolean create(T dto);

    public abstract boolean delete(int vin);
}
