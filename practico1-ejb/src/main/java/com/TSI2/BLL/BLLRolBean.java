package com.TSI2.BLL;

import com.TSI2.DAL.DALRolBeanLocal;
import com.TSI2.Entidades.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BLLRolBean implements BLLRolBeanLocal{

    @Inject
    private DALRolBeanLocal roles;
    
    @Override
    public boolean addRol(String nombre, String descripcion) {
        Rol R = new Rol(nombre,descripcion);
        return roles.save(R);
    }

    @Override
    public boolean updateRol(int id, String nombre, String descripcion) {
        Rol R = roles.find(id);
        R.setName(nombre);
        R.setDescription(descripcion);
        return roles.save(R);
    }

    @Override
    public Rol getRol(int id) {
        return roles.find(id);
    }

    @Override
    public List<Rol> getRoles() {
        return roles.findAll();
    }

    @Override
    public boolean deleteRol(int id) {
        Rol R = roles.find(id);
        if(R == null){
            return false;
        }
        return roles.delete(R);
    }

}
