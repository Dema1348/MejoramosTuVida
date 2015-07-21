/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.HorasDsponibles;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface HorasDsponiblesDAO {

    public void delete(HorasDsponibles horasDsponibles);
    public void create(HorasDsponibles horasDsponibles);
    public List<HorasDsponibles> listar();
    public HorasDsponibles find(Integer id);
    public void update(HorasDsponibles horasDsponibles);
}
