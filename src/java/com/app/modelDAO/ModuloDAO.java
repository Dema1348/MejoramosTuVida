/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.Modulo;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface ModuloDAO {

    public void delete(Modulo modulo);
    public void create(Modulo modulo);
    public List<Modulo> listar();
    public Modulo find(Integer id);
    public void update(Modulo modulo);
}
