/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.Cliente;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface ClienteDAO {

    public void delete(Cliente Cliente);
    public void create(Cliente Cliente);
    public List<Cliente> listar();
    public Cliente find(String rut);
    public void update(Cliente Cliente);
}
