package com.scbastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Valor;

@Repository
public interface ValoresRepository extends JpaRepository<Valor, Long>{

}
