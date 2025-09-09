package com.api.consultorios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.consultorios.entity.Turno;


@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long>{

}
