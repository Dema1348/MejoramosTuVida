<%-- 
    Document   : crearHorario
    Created on : 19-11-2014, 23:32:55
    Author     : EdsonAlexander
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.model.Modulo"%>
<%@page import="com.app.modelDAOPImpl.HorasDsponiblesDAOImpl" session="true"%>
<%@page import="com.app.modelDAOPImpl.ModuloDAOImpl" session="true"%>
<%@page import="com.app.modelDAOPImpl.CalendarioDAOImpl" session="true"%>
<%@page import="com.app.modelDAOPImpl.UserDAOImpl" session="true"%>
<%@page import="com.app.modelDAOPImpl.HorasDsponiblesDAOImpl" session="true"%>
<%@page import="com.app.model.HorasDsponibles" session="true"%>
<%@page import="com.app.model.Calendario" session="true"%>
<%@page import="com.app.model.Usuario" session="true"%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%
    try {
        Usuario usuario = new Usuario();
        HttpSession sesion = request.getSession();
        usuario = (Usuario) sesion.getAttribute("usuario");
        int valor = Integer.parseInt(request.getParameter("valor"));
        int idModulo = Integer.parseInt(request.getParameter("modulo"));
        int idCalendario = Integer.parseInt(request.getParameter("fecha"));
        String rut = request.getParameter("rut");
        ModuloDAOImpl moduloDAOImpl = new ModuloDAOImpl();
        Modulo modulo = moduloDAOImpl.find(idModulo);
        CalendarioDAOImpl calendarioDAOImpl = new CalendarioDAOImpl();
        Calendario calendario = calendarioDAOImpl.find(idCalendario);
        UserDAOImpl UserDAOImpl = new UserDAOImpl();
        Usuario user = UserDAOImpl.find(rut);

        HorasDsponibles horasDsponibles = new HorasDsponibles(null, true, valor, modulo, calendario, user);

    //buscar si esta repetido el horario
        HorasDsponiblesDAOImpl horasDsponiblesDAOImpl = new HorasDsponiblesDAOImpl();
        List<HorasDsponibles> horasDsponiblesL = horasDsponiblesDAOImpl.listar();
        boolean ok = false;
        for (int i = 0; i < horasDsponiblesL.size(); i++) {
            if (horasDsponiblesL.get(i).getIdrutuser().getRut().equals(user.getRut()) && horasDsponiblesL.get(i).getIdmodulo().getIncio().equals(modulo.getIncio()) && horasDsponiblesL.get(i).getIdcalentadrio().getFecha().equals(calendario.getFecha())) {
                out.print("El horario que intenta registrar se encuentra repedito.");
                ok = true;
            }
        }
        if (!ok) {
             horasDsponiblesDAOImpl.create(horasDsponibles);
            out.print("El modulo de  horario ha sido habilitado con exito");
            DemoLogFile.info("El asiste a creado un nuevo modulo de horario");
        }
    } catch (Exception error) {
        DemoLogFile.info("El modulo creado no pudo ser procesado");
        out.print("Modulo horario habilitado sin exito");
    }
%>
