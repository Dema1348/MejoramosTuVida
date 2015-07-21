/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.ReservaHora;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface ReservaHoraDAO {

    public void delete(ReservaHora reservaHora);
    public void create(ReservaHora reservaHora);
    public List<ReservaHora> listar();
    public ReservaHora find(Integer id);
    public void update(ReservaHora reservaHora);
}
