package com.api.rest.api_rest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.api_rest.Entities.Producto;
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
