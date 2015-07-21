/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.Pago;
import com.app.modelDAO.PagoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class PagoDAOImpl implements PagoDAO{
    private List<Pago> pagos;
    private  EntityManager em;
    EntityManagerFactory factory;
    private Pago pago;
    
    public PagoDAOImpl() {
        pagos= new ArrayList<Pago>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<Pago> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Pago c ");
        pagos= q.getResultList();
        em.close();
        return  pagos;    
     
    }

    @Override
    public Pago find(Integer id) {
        init();
        pago = em.find(Pago.class, id); 
        em.close();
        return pago;
    }

    @Override
    public void update(Pago pago) {
         init();
        this.pago=em.find(Pago.class, pago.getId());
        this.pago= pago;
        em.merge(this.pago);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Pago pago) {
        init();
        pago = em.find(Pago.class, pago.getId()); 
        em.remove(pago);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(Pago pago) {
        init();
        em.persist(pago);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
}
