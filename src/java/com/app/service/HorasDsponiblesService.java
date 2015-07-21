/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.service;

import com.app.log.DemoLogFile;
import com.app.model.HorasDsponibles;
import com.app.modelDAOPImpl.HorasDsponiblesDAOImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class HorasDsponiblesService {
    List<HorasDsponibles> horasDsponibleses;
    HorasDsponiblesDAOImpl horasDsponiblesDAOImpl= new HorasDsponiblesDAOImpl();
    
    public  List<HorasDsponibles>  listarHorasDisponibles(){
         List<HorasDsponibles> horasFiltradas= new ArrayList<HorasDsponibles>();
        for (HorasDsponibles horasDsponibles : horasDsponiblesDAOImpl.listar()) {
            if(horasDsponibles.getEstado())
            horasFiltradas.add(horasDsponibles);
        }
        return horasFiltradas;
    }
    
    
    public  List<HorasDsponibles>  listarHorasDisponibles(String rut){
         List<HorasDsponibles> horasFiltradas= new ArrayList<HorasDsponibles>();
        for (HorasDsponibles horasDsponibles : horasDsponiblesDAOImpl.listar()) {
            if(horasDsponibles.getIdrutuser().getRut().equals(rut))
            horasFiltradas.add(horasDsponibles);
        }
        return horasFiltradas;
    }
    
    public String deleteModulo(Integer id) {
        try {
            HorasDsponibles horasDsponibles= horasDsponiblesDAOImpl.find(id);
            DemoLogFile.info("Se ha borrado el modulo del user "+horasDsponibles.getIdrutuser().getRut());
            horasDsponiblesDAOImpl.delete(horasDsponibles);
            return "Se ha borrado con modulo programado ";
        } catch (Exception error) {
            DemoLogFile.error("Error al procesar su borrado de horario");
            return "Ha existido un problema al realizar su peticion por favor intente otra vez";
        }
    }
    
}
