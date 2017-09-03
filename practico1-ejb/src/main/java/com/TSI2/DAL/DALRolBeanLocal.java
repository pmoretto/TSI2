package com.TSI2.DAL;

import com.TSI2.Entidades.Rol;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DALRolBeanLocal {

    public boolean save(Rol u);

    public boolean delete(Rol u);

    public Rol find(int rolId);

    public boolean exists(Rol u);

    public List<Rol> findAll();

}
