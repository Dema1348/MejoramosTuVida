/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.Calendario;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface CalendarioDAO {

    public void delete(Calendario calendario);
    public void create(Calendario calendario);
    public List<Calendario> listar();
    public Calendario find(Integer id);
    public void update(Calendario calendario);
}
