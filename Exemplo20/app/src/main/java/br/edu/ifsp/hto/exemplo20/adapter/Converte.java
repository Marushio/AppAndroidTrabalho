package br.edu.ifsp.hto.exemplo20.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Marcio on 02/06/2016.
 */
public class Converte {
    public String converteData(Date data){
        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
        Date date = null;
        try {
            date = (Date) formatter.parse(data.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" +
                (cal.get(Calendar.MONTH) + 1) +
                "/" +         cal.get(Calendar.YEAR);
        return formatedDate;
    }
    public String converteMoeda(Double valor){
        String moeda="";
        return moeda;
    }
}
