/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.HorasDsponibles;
import com.app.modelDAO.HorasDsponiblesDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class HorasDsponiblesDAOImpl implements HorasDsponiblesDAO{
    private List<HorasDsponibles> HorasDsponiblesL;
    private  EntityManager em;
    EntityManagerFactory factory;
    private HorasDsponibles horasDsponibles;
    
    public HorasDsponiblesDAOImpl() {
        HorasDsponiblesL= new ArrayList<HorasDsponibles>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<HorasDsponibles> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM HorasDsponibles c ");
        HorasDsponiblesL= q.getResultList();
        em.close();
        return  HorasDsponiblesL;    
     
    }

    @Override
    public HorasDsponibles find(Integer id) {
        init();
        horasDsponibles = em.find(HorasDsponibles.class, id); 
        em.close();
        return horasDsponibles;
    }

    @Override
    public void update(HorasDsponibles horasDsponibles) {
         init();
        this.horasDsponibles=em.find(HorasDsponibles.class, horasDsponibles.getId());
        this.horasDsponibles= horasDsponibles;
        em.merge(this.horasDsponibles);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(HorasDsponibles horasDsponibles) {
        init();
        horasDsponibles = em.find(HorasDsponibles.class, horasDsponibles.getId()); 
        em.remove(horasDsponibles);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(HorasDsponibles horasDsponibles) {
        init();
        em.persist(horasDsponibles);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
    
    
}
