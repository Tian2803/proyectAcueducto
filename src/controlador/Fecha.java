/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author Sebastian Burgos
 */
public class Fecha {
    public String fechaActual(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
        Calendar calendar = Calendar.getInstance();
        
        Date date = calendar.getTime();
        String fechaActual = dateFormat.format(date);
        return fechaActual;
    }
    
    public String mesActual(){
        Month mes = LocalDate.now().getMonth();
        String mesActual = mes.getDisplayName(TextStyle.FULL,new Locale("es","ES"));
        //String pLetra = mesActual.substring(0,1);
        //String mayuscula = pLetra.toUpperCase();
        //String demasLetras = mesActual.substring(1,mesActual.length());
        //mesActual = mayuscula + demasLetras;
        return mesActual;
    }
}
