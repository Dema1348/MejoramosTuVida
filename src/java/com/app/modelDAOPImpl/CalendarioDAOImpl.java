/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.Calendario;
import com.app.modelDAO.CalendarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class CalendarioDAOImpl implements CalendarioDAO{
    private List<Calendario> calendarios;
    private  EntityManager em;
    EntityManagerFactory factory;
    private Calendario calendario;
    
    public CalendarioDAOImpl() {
        calendarios= new ArrayList<Calendario>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<Calendario> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Calendario c ");
        calendarios= q.getResultList();
        em.close();
        return  calendarios;    
     
    }

    @Override
    public Calendario find(Integer id) {
        init();
        calendario = em.find(Calendario.class, id); 
        em.close();
        return calendario;
    }

    @Override
    public void update(Calendario calendario) {
         init();
        this.calendario=em.find(Calendario.class, calendario.getId());
        this.calendario= calendario;
        em.merge(this.calendario);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Calendario calendario) {
        init();
        calendario = em.find(Calendario.class, calendario.getId()); 
        em.remove(calendario);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(Calendario calendario) {
        init();
        em.persist(calendario);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
}
