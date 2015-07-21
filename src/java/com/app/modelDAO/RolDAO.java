/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.Rol;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface RolDAO {

    public void delete(Rol rol);
    public void create(Rol rol);
    public List<Rol> listar();
    public Rol find(Integer id);
    public void update(Rol rol);
}
