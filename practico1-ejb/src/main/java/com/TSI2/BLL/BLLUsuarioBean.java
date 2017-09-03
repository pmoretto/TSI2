package com.TSI2.BLL;

import com.TSI2.Entidades.Rol;
import com.TSI2.Entidades.Usuario;
import java.util.List;
import com.TSI2.DAL.DALRolBeanLocal;
import com.TSI2.DAL.DALUsuarioBeanLocal;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BLLUsuarioBean implements BLLUsuarioBeanLocal{

    @Inject 
    private DALUsuarioBeanLocal usuarios;
    @Inject
    private DALRolBeanLocal roles;
    
    @Override
    public boolean addUsuario(String nombre, String apellido, String username, String email, String password, int rolId) {
        Usuario X = usuarios.find(username);
        if(X != null){
            return false;
        }
        Rol R = roles.find(rolId);
        if(R != null){
            return false;
        }
        return usuarios.save(new Usuario(username, password, nombre, username, email, R));
    }

    @Override
    public boolean updateUsuario(String nombre, String apellido, String username, String email, String password, int rolId) {
        Usuario X = usuarios.find(username);
        if(X != null){
            return false;
        }
        Rol R = roles.find(rolId);
        if(R != null){
            return false;
        }
        X.setName(nombre);
        X.setLastname(apellido);
        X.setUsername(username);
        X.setEmail(email);
        X.setPassword(password);
        X.setRoleid(R);
        return usuarios.save(X);
    }

    @Override
    public boolean deleteUsuario(String username) {
        Usuario X = usuarios.find(username);
        if(X == null){
            return false; 
        }
        return usuarios.delete(X);
    }

    @Override
    public Usuario getUsuario(String username) {
        Usuario X = usuarios.find(username);
        return X;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios.findAll();
    }

    @Override
    public List<Usuario> findAll(String filtro, int pagina) {
        return usuarios.findAll(filtro, pagina);
    }

}
