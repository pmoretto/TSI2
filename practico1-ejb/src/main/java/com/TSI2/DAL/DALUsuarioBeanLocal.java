package com.TSI2.DAL;

import java.util.List;
import com.TSI2.Entidades.Usuario;
import javax.ejb.Local;

@Local
public interface DALUsuarioBeanLocal {
    
    public boolean save(Usuario u);

    public boolean delete(Usuario u);

    public Usuario find(String username);

    public boolean exists(Usuario u);

    public List<Usuario> findAll();

    public List<Usuario> findAll(String filtro, int pagina);
}
