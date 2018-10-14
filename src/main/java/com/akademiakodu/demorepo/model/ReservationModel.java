package com.akademiakodu.demorepo.model;

import com.akademiakodu.demorepo.model.forms.ReservationForm;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservations")
/*@Getter
@Setter
@EqualsAndHashCode
@ToString*/
@NoArgsConstructor
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    @Column(name = "firstname")
    private String firstname;
    private String lastname;
    private LocalDate date;
    private String adres;

    public ReservationModel (ReservationForm form){
        firstname = form.getFirstname();
        lastname = form.getLastname();
        date = form.getFormatedDate();
        adres = form.getAdres();

    }


}
