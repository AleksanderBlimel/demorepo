package com.akademiakodu.demorepo.model.repositories;


import com.akademiakodu.demorepo.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/*
C  - cearate
R  - read
U  - update
D  - delete
 */
@Repository  //
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {
//metody do wyszukiwani

ReservationModel findByLastname(String name);

List<ReservationModel> findByIdGreaterThan (Integer id);

List<ReservationModel> findByDateAfter(LocalDate date);

List<ReservationModel> findByDateBetween(LocalDate date, LocalDate date2);

List<ReservationModel> findByLastnameContains(String lastname);


}