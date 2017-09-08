package com.scbastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long> {

}
