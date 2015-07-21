/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.service;
import com.app.log.DemoLogFile;
import com.app.model.Cliente;
import com.app.model.Modulo;
import com.app.model.Pago;
import com.app.model.ReservaHora;
import com.app.model.Usuario;
import com.app.modelDAOPImpl.ClienteDAOImpl;
import com.app.modelDAOPImpl.ModuloDAOImpl;
import com.app.modelDAOPImpl.PagoDAOImpl;
import com.app.modelDAOPImpl.ReservaHoraDAOImpl;
import com.app.modelDAOPImpl.UserDAOImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EdsonAlexander
 */
public class PagoService {

    PagoDAOImpl pagoDAOImpl = new PagoDAOImpl();
    ReservaHoraDAOImpl reservaHoraDAOImpl = new ReservaHoraDAOImpl();
    ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
    UserDAOImpl userDAOImpl = new UserDAOImpl();
    ModuloDAOImpl moduloDAOImpl = new ModuloDAOImpl();
    ReservaHora reservaHora;
    Cliente cliente;
    Usuario usuario;
    Modulo modulo;
    
    public String realizarPago(Integer id) {
        try {
            reservaHora = reservaHoraDAOImpl.find(id);
            cliente = clienteDAOImpl.find(reservaHora.getIdrutcliente().getRut());
            usuario = userDAOImpl.find(reservaHora.getIdhora().getIdrutuser().getRut());
            pagoDAOImpl.create(new Pago(null, null,reservaHora.getIdhora().getValor(), cliente, usuario));
            DemoLogFile.info("Se realizo un pago del cliente "+cliente.getRut()+" con el valor de "+ reservaHora.getIdhora().getValor());
            modulo=moduloDAOImpl.find(reservaHora.getIdhora().getIdmodulo().getId());
            moduloDAOImpl.delete(modulo);
            
            return "Se ha registrado el pago ";
        } catch (Exception error) {
             DemoLogFile.warn("Se intento realizar un pago pero fallo la solicitud");
            return "Ha existido un problema al realizar su peticion por favor intente otra vez";

        }

    }
    
    public List<Pago> pagosFiltro(String rut, String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        List<Pago> pagosL = new ArrayList<Pago>();
        pagosL = pagoDAOImpl.listar();
        DemoLogFile.info("Se realizo una consulta con el rut "+rut+" y fecha "+fecha);
        List<Pago> pagosFiltrados = new ArrayList<Pago>();
        if (!rut.equals("General")) {
            for (Pago pagoF : pagosL) {
                if (pagoF.getIdrutuser().getRut().equals(rut)) {
                    if (formato.format(pagoF.getFechapago()).equals(fecha)) {
                        pagosFiltrados.add(pagoF);
                    }
                }
            }
            return pagosFiltrados;
        } else {

            for (Pago pagoF : pagosL) {
                if (formato.format(pagoF.getFechapago()).equals(fecha)) {
                    pagosFiltrados.add(pagoF);
                }

            }
            return pagosFiltrados;
        }
    }
    
    public List<Pago> pagosFiltroR(String rut, String fecha, String fecha2) throws ParseException {
        Calendar busqueda = new GregorianCalendar();
        Date fechaInicio = null;
        Date fechafinal = null;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        fechaInicio = formatoDelTexto.parse(fecha);
        fechafinal = formatoDelTexto.parse(fecha2);
        List<Pago> pagosL = new ArrayList<Pago>();
        pagosL = pagoDAOImpl.listar();
         DemoLogFile.info("Se realizo una consulta con el rut "+rut+" entre las fechas "+fecha+" "+fecha2);
        List<Pago> pagosFiltrados = new ArrayList<Pago>();
        if (!rut.equals("General")) {
            for (Pago pagoF : pagosL) {
                if (pagoF.getIdrutuser().getRut().equals(rut)) {

                    if (fechaInicio.before(pagoF.getFechapago()) && fechafinal.after(pagoF.getFechapago())) {
                        pagosFiltrados.add(pagoF);
                    }

                }
            }
            return pagosFiltrados;
        } else {
            for (Pago pagoF : pagosL) {
                if (fechaInicio.before(pagoF.getFechapago()) && fechafinal.after(pagoF.getFechapago())) {
                    pagosFiltrados.add(pagoF);
                }

            }
            return pagosFiltrados;
        }
    }
    
}
