package com.TSI2.DAL;

import com.TSI2.Entidades.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DALRolBean implements DALRolBeanLocal{
@PersistenceContext(unitName = "com.mycompany_ejb_ejb_1PU2")
    private EntityManager em;

    @Override
    public boolean save(Rol u) {
        em.persist(u);
        return exists(u);
    }

    @Override
    public boolean delete(Rol u) {
        em.remove(u);
        return exists(u);
    }

    @Override
    public Rol find(int rol) {
        return em.find(Rol.class,rol);
    }

    @Override
    public boolean exists(Rol r) {
        return em.contains(r);
    }

    @Override
    public List<Rol> findAll() {
        return em.createQuery("SELECT r FROM Rol r",Rol.class).getResultList();
    }
}
