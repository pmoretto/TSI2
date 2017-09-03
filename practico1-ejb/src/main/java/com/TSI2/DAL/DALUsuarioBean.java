package com.TSI2.DAL;

import com.TSI2.Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DALUsuarioBean implements DALUsuarioBeanLocal{
    
    @PersistenceContext(unitName = "com.mycompany_ejb_ejb_1PU2")
    private EntityManager em;

    @Override
    public boolean save(Usuario u) {
        em.persist(u);
        return exists(u);
    }

    @Override
    public boolean delete(Usuario u) {
        em.remove(u);
        return exists(u);
    }

    @Override
    public Usuario find(String username) {
        return em.find(Usuario.class, username);
    }

    @Override
    public boolean exists(Usuario u) {
        return em.contains(u);
    }

    @Override
    public List<Usuario> findAll() {
       return em.createQuery("SELECT u FROM Usuario u",Usuario.class).getResultList();
    }

    @Override
    public List<Usuario> findAll(String filtro, int pagina) {
        int skip = ((pagina * 10) - 10);
        return em.createQuery("SELECT u FROM Usuario u WHERE u.username LIKE :f", Usuario.class).setParameter("f", "%" + filtro + "%").setMaxResults(10).setFirstResult(skip).getResultList();
    }

}
