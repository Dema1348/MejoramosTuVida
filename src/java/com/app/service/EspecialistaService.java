/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.service;
import com.app.model.Usuario;
import com.app.modelDAOPImpl.EspecialistaDAOImpl;
import java.util.List;
/**
 *
 * @author cetecom
 */
public class EspecialistaService {
    EspecialistaDAOImpl especialistaDAOImpl= new EspecialistaDAOImpl();
    
    public List<Usuario> listaEspecialistas(){
        return  especialistaDAOImpl.listar();
    }
}
