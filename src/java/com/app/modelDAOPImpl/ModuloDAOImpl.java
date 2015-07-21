/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.Modulo;
import com.app.modelDAO.ModuloDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class ModuloDAOImpl implements ModuloDAO{
    private List<Modulo> modulos;
    private  EntityManager em;
    EntityManagerFactory factory;
    private Modulo modulo;
    
    public ModuloDAOImpl() {
        modulos= new ArrayList<Modulo>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<Modulo> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Modulo c ");
        modulos= q.getResultList();
        em.close();
        return  modulos;    
     
    }

    @Override
    public Modulo find(Integer id) {
        init();
        modulo = em.find(Modulo.class, id); 
        em.close();
        return modulo;
    }

    @Override
    public void update(Modulo modulo) {
         init();
        this.modulo=em.find(Modulo.class, modulo.getId());
        this.modulo= modulo;
        em.merge(this.modulo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Modulo modulo) {
        init();
        modulo = em.find(Modulo.class, modulo.getId()); 
        em.remove(modulo);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(Modulo modulo) {
        init();
        em.persist(modulo);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
}
