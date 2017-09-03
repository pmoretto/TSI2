package com.TSI2.BLL;

import com.TSI2.Entidades.Rol;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BLLRolBeanLocal {
    
    public boolean addRol(String nombre, String descripcion);

    public boolean updateRol(int id, String nombre, String descripcion);

    public Rol getRol(int id);

    public List<Rol> getRoles();

    public boolean deleteRol(int id);
}
