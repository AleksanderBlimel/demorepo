package com.akademiakodu.demorepo.Controlers;


import com.akademiakodu.demorepo.model.ReservationModel;
import com.akademiakodu.demorepo.model.forms.ReservationForm;
import com.akademiakodu.demorepo.model.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

@Controller
public class MainController {

    //JAKA ADNOTACJA? - chce powiązac repo z kontrolerem
    @Autowired //autopowiazanie na powiazaniu
    ReservationRepository reservationRepository;


    @GetMapping("/")
 //   @ResponseBody
    public String index(Model model) { //nowy obiekt dodajemy w nim wszytskie dane i zapisujemy w repo
       /* ReservationModel model = new ReservationModel();
        model.setAdres("Warszawa");                                             //sety są z adnotacji Date bo to ona tworzy setery i getery
        model.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
        model.setFirstname("Adam");
        model.setLastname("Kowalski");*/

    //    reservationRepository.save(model);
model.addAttribute("reservationForm", new ReservationForm());
        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form ,
                        BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "index";
        }

        reservationRepository.save(new ReservationModel(form));

    return "index";

    }


    @GetMapping("/test")   //uwaga
    @ResponseBody
    public String test(){
        return reservationRepository.findByLastname("Kot").toString(); //piszemy metode której nie ma w bibliotece

    }
    @GetMapping("/test2")
    @ResponseBody
    public String test2(){

        return reservationRepository.findById(2).toString(); // ta metoda jest z automatu
    }
    @GetMapping("/test3")
    @ResponseBody
    public String test3(){

        return reservationRepository.findByIdGreaterThan(2).toString(); //piszemy metode której nie
    }
    @GetMapping("/test4")
    @ResponseBody
    public String test4(){

        return reservationRepository.findByDateAfter(LocalDate.of(2018,10, 1)).toString();
    }

    @GetMapping("/test5")
    @ResponseBody
    public String test5(){

        return reservationRepository.findByDateBetween(LocalDate.now(),LocalDate.now().plusWeeks(1)).toString();
    }
    @GetMapping("/test6")
    @ResponseBody
    public String test6(){

        return reservationRepository.findByLastnameContains("a").toString();
    }


}

