/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.modelDAO;

import com.app.model.Pago;
import java.util.List;

/**
 *
 * @author EdsonAlexander
 */
public interface PagoDAO {

    public void delete(Pago pago);
    public void create(Pago pago);
    public List<Pago> listar();
    public Pago find(Integer id);
    public void update(Pago pago);
}
