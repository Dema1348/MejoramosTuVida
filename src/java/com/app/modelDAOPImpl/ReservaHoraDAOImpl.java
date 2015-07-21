/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.ReservaHora;
import com.app.modelDAO.ReservaHoraDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class ReservaHoraDAOImpl implements ReservaHoraDAO{
    private List<ReservaHora> reservaHoras;
    private  EntityManager em;
    EntityManagerFactory factory;
    private ReservaHora reservaHora;
    
    public ReservaHoraDAOImpl() {
        reservaHoras= new ArrayList<ReservaHora>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<ReservaHora> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM ReservaHora c ");
        reservaHoras= q.getResultList();
        em.close();
        return  reservaHoras;    
     
    }

    @Override
    public ReservaHora find(Integer id) {
        init();
        reservaHora = em.find(ReservaHora.class, id); 
        em.close();
        return reservaHora;
    }

    @Override
    public void update(ReservaHora reservaHora) {
         init();
        this.reservaHora=em.find(ReservaHora.class, reservaHora.getId());
        this.reservaHora= reservaHora;
        em.merge(this.reservaHora);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(ReservaHora reservaHora) {
        init();
        reservaHora = em.find(ReservaHora.class, reservaHora.getId()); 
        em.remove(reservaHora);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(ReservaHora reservaHora) {
        init();
        em.persist(reservaHora);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
}
