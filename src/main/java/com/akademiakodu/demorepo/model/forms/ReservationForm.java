package com.akademiakodu.demorepo.model.forms;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservationForm {

    @Getter
    @NotBlank
    @Size(min = 3, max =15)
    private String firstname;
    @Getter
    @NotBlank
    @Size(min = 3, max =15)
    private String lastname;
    @Getter
    // do każdej adnotacji walidacji mozemy dodoac wiadomosc
@Pattern(regexp = "2[0-9]{3}-[0-1][0-9]-[0-3][0-9]")
    private String date;
    @Getter
    @NotBlank
    @Size(min = 3, max = 5)
    private String adres;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDate() {
        return date;
    }

    public String getAdres() {
        return adres;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   /*
   //stare podejscie
   public Date getFormatedDate(){

     try {
         //YYYY-MM-DD
         return new Date(format.parse(date).getTime())
     } catch (ParseException e){
         e.printStackTrace();
     }
     return null;
     } */

    public LocalDate getFormatedDate(){
        //YYYY-MM-DD
        return LocalDate.parse(date, format);
    }



}