/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.service;
import com.app.log.DemoLogFile;
import com.app.model.Usuario;
import com.app.modelDAOPImpl.UserDAOImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class UserService {
    List<Usuario> usuarios;
    UserDAOImpl clienteDAOImpl= new UserDAOImpl();
    public Usuario buscarUsuario(String rut, String pass){
        usuarios=clienteDAOImpl.listar();
        DemoLogFile.info("Se busco el usuario "+rut+" en la base de datos");
        for (Usuario user : usuarios) {
            if(user.getRut().equals(rut)&&user.getPass().equals(pass) )
                return user;
        }
        
        return null;
    }
    
    public List<Usuario> userSP(){
        usuarios=clienteDAOImpl.listar();
        List<Usuario> usuarioFiltrado= new ArrayList<Usuario>();
      
        for (Usuario user : usuarios) {
           if(user.getRolId().getId()==4 || user.getRolId().getId()==3 )
               usuarioFiltrado.add(user);
        }
        
        return usuarioFiltrado;
    }
    
    
}
