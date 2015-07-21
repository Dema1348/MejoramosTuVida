/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.service;
import com.app.log.DemoLogFile;
import com.app.model.Cliente;
import com.app.modelDAOPImpl.ClienteDAOImpl;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class ClienteService {
    List<Cliente> clientes;
    ClienteDAOImpl clienteDAOImpl= new ClienteDAOImpl();
    
    public Cliente buscarCliente(String rut, String pass){
        clientes=clienteDAOImpl.listar();
        DemoLogFile.info("Se busco al cliente "+rut+" en la base de datos");
        for (Cliente cliente : clientes) {
            if(cliente.getRut().equals(rut)&&cliente.getPass().equals(pass))
                return cliente;
        }
        
        return null;
    }
    
    public boolean compararPass(String pass1, String pass2){
        if(pass1.equals(pass2))
            return true;
        else
            return false;
    }
    
    public String addCliente(Cliente cliente){
        try {
            clienteDAOImpl.create(cliente);
            DemoLogFile.info("Se ha registrado un nuevo cliente de rut "+cliente.getRut());
            return "Se ha registro con exito, revice su correo " + cliente.getCorreo() + " para mayor informacion ";
        } catch (Exception error) {
             DemoLogFile.warn("Ha existido un problema al registrar un nuevo cliente");
            return "Ha existido un problema por favor verifique los datos ingresados";
        }

    }
    
}
