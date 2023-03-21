package com.vacaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.modelos.Vacaciones;

@Repository
public interface VacacionesRepository extends JpaRepository<Vacaciones,Integer>{

}
