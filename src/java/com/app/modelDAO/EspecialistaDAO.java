/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.Usuario;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface EspecialistaDAO {

    public void delete(Usuario usuario);
    public void create(Usuario usuario);
    public List<Usuario> listar();
    public Usuario find(String rut);
    public void update(Usuario usuario);
}
