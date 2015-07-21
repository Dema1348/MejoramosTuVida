/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.service;
import com.app.mail.Email;
import com.app.model.Cliente;
import com.app.model.HorasDsponibles;
import com.app.model.ReservaHora;
import com.app.modelDAOPImpl.ClienteDAOImpl;
import com.app.modelDAOPImpl.HorasDsponiblesDAOImpl;
import com.app.modelDAOPImpl.ReservaHoraDAOImpl;
import com.app.log.DemoLogFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author EdsonAlexander
 */
public class ReservaHoraService {
    HorasDsponiblesDAOImpl horasDsponiblesDAOImpl = new HorasDsponiblesDAOImpl();
    ReservaHoraDAOImpl reservaHoraDAOImpl = new ReservaHoraDAOImpl();
    ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
    HorasDsponibles horasDsponibles;
    ReservaHora reservaHora;
    Cliente cliente;
    Email email,emailCancel;
    
   
    public String addReserva(Integer id, String rut) {
        try{
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");    
        horasDsponibles = horasDsponiblesDAOImpl.find(id);
        horasDsponibles.setEstado(false);
        horasDsponiblesDAOImpl.update(horasDsponibles);
        cliente= clienteDAOImpl.find(rut);
        reservaHoraDAOImpl.create(new ReservaHora(null, horasDsponibles, cliente));
       DemoLogFile.info("Se registrado una reserva para el cliente "+cliente.getRut());
       email= new Email(cliente.getCorreo(), "Reserva de hora", 
               "Estimado cliente ha reservado una hora con el sicologo o especialista "+horasDsponibles.getIdrutuser().getNombres() +
                       " "+horasDsponibles.getIdrutuser().getApellidos()+
                       ", con un valor de $"+horasDsponibles.getValor()+
                       " para el dia "+formato.format(horasDsponibles.getIdcalentadrio().getFecha())+
                       " dentro del modulo "+horasDsponibles.getIdmodulo().getIncio().toString().substring(10,20)+
                       " - "+horasDsponibles.getIdmodulo().getTermino().toString().substring(10,20)+".\nSaludos estimado cliente.");
       String mensajeMail="";
       if(email.sendMail())
            mensajeMail=", revice el correo electronico donde se encuentra la informacion de la reserva";
       else
            mensajeMail=", pero se registro un problema al enviar la informacion a su correo";
            
        return "Se ha registrado con exito su cita"+mensajeMail;
        }
        catch(Exception error){
         return "Ha existido un problema al realizar su peticion por favor intente otra vez";
        }
    }
    
    
    
    public List<ReservaHora> reservasTotales(){
        return reservaHoraDAOImpl.listar();
    }
    
    public List<ReservaHora> reservasCliente(String rut){
    List<ReservaHora> reservas= reservaHoraDAOImpl.listar();
    List<ReservaHora> reservasFiltro= new ArrayList<ReservaHora>();
        for (ReservaHora reservaCli : reservas) {
            if(reservaCli.getIdrutcliente().getRut().equals(rut)){
                reservasFiltro.add(reservaCli);
            }
        }
        return reservasFiltro;
    }
    
    public List<ReservaHora> reservasEspecilista(String rut){
    List<ReservaHora> reservas= reservaHoraDAOImpl.listar();
    List<ReservaHora> reservasFiltro= new ArrayList<ReservaHora>();
     DemoLogFile.info("Se han listado las reservas del especialista "+rut);
        for (ReservaHora reservaCli : reservas) {
            if(reservaCli.getIdhora().getIdrutuser().getRut().equals(rut)){
                reservasFiltro.add(reservaCli);
            }
        }
        return reservasFiltro;
    }
    
    public String deleteReserva(Integer id) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
            reservaHora = reservaHoraDAOImpl.find(id);
            DemoLogFile.info("Se ha borrado la reserva del cliente" + reservaHora.getIdrutcliente().getRut());
            horasDsponibles = horasDsponiblesDAOImpl.find(reservaHora.getIdhora().getId());
            horasDsponibles.setEstado(true);
            horasDsponiblesDAOImpl.update(horasDsponibles);
            emailCancel = new Email(reservaHora.getIdrutcliente().getCorreo(), "Reserva de hora",
                    "Estimado cliente se ha anulado una hora con el sicologo o especialista " + reservaHora.getIdhora().getIdrutuser().getNombres()
                    + " " + reservaHora.getIdhora().getIdrutuser().getApellidos()
                    + ", con un valor de $" + reservaHora.getIdhora().getValor()
                    + " para el dia " + formato.format(reservaHora.getIdhora().getIdcalentadrio().getFecha())
                    +" dentro del modulo "+reservaHora.getIdhora().getIdmodulo().getIncio().toString().substring(10,20)
                    +" - "+reservaHora.getIdhora().getIdmodulo().getTermino().toString().substring(10,20)
                    +".\nSaludos estimado cliente");
            String mensajeMail = "";
            if (emailCancel.sendMail()) {
                mensajeMail = ", se ha enviado un correo al cliente con la informacion de la cancelacion de la hora";
            } else {
                mensajeMail = ", pero se registro un problema al enviar la informacion al correo del cliente";
            }
            reservaHoraDAOImpl.delete(reservaHora);

            return "Se ha borrado con exito su cita"+mensajeMail;
        } catch (Exception error) {
            DemoLogFile.error("Error al procesar el borrado de una cita");
            return "Ha existido un problema al realizar su peticion por favor intente otra vez";
        }
    }
    
     public String deleteReservaC(Integer id) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
            reservaHora = reservaHoraDAOImpl.find(id);
            DemoLogFile.info("Se ha borrado la reserva del cliente" + reservaHora.getIdrutcliente().getRut());
            horasDsponibles = horasDsponiblesDAOImpl.find(reservaHora.getIdhora().getId());
            horasDsponibles.setEstado(true);
            horasDsponiblesDAOImpl.update(horasDsponibles);
            emailCancel = new Email(reservaHora.getIdrutcliente().getCorreo(), "Reserva de hora",
                    "Estimado cliente ha eliminado una hora con el sicologo o especialista " + reservaHora.getIdhora().getIdrutuser().getNombres()
                    + " " + reservaHora.getIdhora().getIdrutuser().getApellidos()
                    + ", con un valor de $" + reservaHora.getIdhora().getValor()
                    + " para el dia " + formato.format(reservaHora.getIdhora().getIdcalentadrio().getFecha())
                    +" dentro del modulo "+reservaHora.getIdhora().getIdmodulo().getIncio().toString().substring(10,20)
                    +" - "+reservaHora.getIdhora().getIdmodulo().getTermino().toString().substring(10,20)
                    +".\nSaludos estimado cliente");
            String mensajeMail = "";
            if (emailCancel.sendMail()) {
                mensajeMail = ", revice el correo electronico donde se encuentra la informacion de la reserva";
            } else {
                mensajeMail = ", pero se registro un problema al enviar la informacion a su correo";
            }
            reservaHoraDAOImpl.delete(reservaHora);

            return "Se ha borrado con exito su cita"+mensajeMail;
        } catch (Exception error) {
            DemoLogFile.error("Error al procesar el borrado de una cita");
            return "Ha existido un problema al realizar su peticion por favor intente otra vez";
        }
    }
    
    public List<ReservaHora> reservasEspecilistaF(String rut, String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        List<ReservaHora> reservas =new ArrayList<ReservaHora>();
        reservas=reservaHoraDAOImpl.listar();
        DemoLogFile.info("Se ha consultado sobre las reservas del rut "+rut+" en la fecha "+fecha);
        List<ReservaHora> reservasFiltro = new ArrayList<ReservaHora>();
        for (ReservaHora reservaCli : reservas) {
            if (reservaCli.getIdhora().getIdrutuser().getRut().equals(rut) ) {
              if(formato.format(reservaCli.getIdhora().getIdcalentadrio().getFecha()).equals(fecha))
                reservasFiltro.add(reservaCli);
            }
        }
        return reservasFiltro;
    }
    
    
}
