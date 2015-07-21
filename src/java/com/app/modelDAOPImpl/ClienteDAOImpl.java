/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.Cliente;
import com.app.modelDAO.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class ClienteDAOImpl implements ClienteDAO{
    private List<Cliente> clientes;
    private  EntityManager em;
    EntityManagerFactory factory;
    private Cliente cliente;
    
    public ClienteDAOImpl() {
        clientes = new ArrayList<Cliente>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<Cliente> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Cliente c ");
        clientes= q.getResultList();
        em.close();
        return  clientes;    
     
    }

    @Override
    public Cliente find(String rut) {
        init();
        cliente = em.find(Cliente.class, rut); 
        em.close();
        return cliente;
    }

    @Override
    public void update(Cliente cliente) {
         init();
        this.cliente=em.find(Cliente.class, cliente.getRut());
        this.cliente= cliente;
        em.merge(this.cliente);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Cliente cliente) {
        init();
        cliente = em.find(Cliente.class, cliente.getRut()); 
        em.remove(cliente);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(Cliente cliente) {
        init();
        em.persist(cliente);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
}
