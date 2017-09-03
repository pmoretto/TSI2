package com.TSI2.BLL;

import java.util.List;
import com.TSI2.Entidades.Usuario;
import javax.ejb.Local;

@Local
public interface BLLUsuarioBeanLocal{

    public boolean addUsuario(String nombre, String apellido, String username, String email, String password, int rolId);

    public boolean updateUsuario(String nombre, String apellido, String username, String email, String password, int rolId);

    public boolean deleteUsuario(String username);

    public Usuario getUsuario(String username);

    public List<Usuario> getUsuarios();
    
    public List<Usuario> findAll(String filtro, int pagina);
}
