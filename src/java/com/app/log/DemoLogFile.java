/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.log;

import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author PROPIA
 */
public  class DemoLogFile {
    static Logger logger = Logger.getLogger(DemoLogFile.class);
    
    
    
     public static void info(String mensaje){
      URL url = DemoLogFile.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        logger.info("info  " +mensaje);
       
    }
     
    public static void warn(String mensaje){
      URL url = DemoLogFile.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        logger.warn("warn "+ mensaje);
    }
    
    public static void debug(String mensaje){
      URL url = DemoLogFile.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        logger.debug("debug "+ mensaje);
    }
    
    public static void fatal(String mensaje){
      URL url = DemoLogFile.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        logger.fatal("fatal "+ mensaje);
    }
    
    public static void error(String mensaje){
      URL url = DemoLogFile.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        logger.error("error "+ mensaje);
        
    }
     
     

    
}
