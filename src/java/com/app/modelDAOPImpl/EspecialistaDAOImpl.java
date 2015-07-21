/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAOPImpl;
import com.app.model.Usuario;
import com.app.modelDAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author cetecom
 */
public class EspecialistaDAOImpl implements UsuarioDAO{
    private List<Usuario> usuarios;
    private  EntityManager em;
    EntityManagerFactory factory;
    private Usuario usuario;
    
    public EspecialistaDAOImpl() {
        usuarios= new ArrayList<Usuario>();
    }
    
    protected  void init()
    {
        factory = Persistence.createEntityManagerFactory("MejoramosTuVidaPU", System.getProperties());
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
    
    @Override
    public List<Usuario> listar() {
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Usuario c WHERE  c.rolId.id =:custName ").setParameter("custName", 4);
        usuarios= q.getResultList();
        em.close();
        return  usuarios;    
     
    }

    @Override
    public Usuario find(String rut) {
        init();
        usuario = em.find(Usuario.class, rut); 
        em.close();
        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
         init();
        this.usuario=em.find(Usuario.class, usuario.getRut());
        this.usuario= usuario;
        em.merge(this.usuario);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Usuario usuario) {
        init();
        usuario = em.find(Usuario.class, usuario.getRut()); 
        em.remove(usuario);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void create(Usuario usuario) {
        init();
        em.persist(usuario);
        em.flush();
        em.getTransaction().commit();
        em.close();

    }
    
}
