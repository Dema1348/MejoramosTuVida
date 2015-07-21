/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.Rol;
import com.app.modelDAO.RolDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class RolDAOImpl implements RolDAO{
    private List<Rol> rols;
    private  EntityManager em;
    EntityManagerFactory factory;
    private Rol rol;
    
    public RolDAOImpl() {
        rols= new ArrayList<Rol>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<Rol> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Rol c ");
        rols= q.getResultList();
        em.close();
        return  rols;    
     
    }

    @Override
    public Rol find(Integer id) {
        init();
        rol = em.find(Rol.class, id); 
        em.close();
        return rol;
    }

    @Override
    public void update(Rol rol) {
         init();
        this.rol=em.find(Rol.class, rol.getId());
        this.rol= rol;
        em.merge(this.rol);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Rol rol) {
        init();
        rol = em.find(Rol.class, rol.getId()); 
        em.remove(rol);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(Rol rol) {
        init();
        em.persist(rol);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
}
