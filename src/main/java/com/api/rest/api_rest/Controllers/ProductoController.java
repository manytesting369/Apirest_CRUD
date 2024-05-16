package com.api.rest.api_rest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.api_rest.Entities.Producto;
import com.api.rest.api_rest.Repositories.ProductoRepositorio;

@RestController
@RequestMapping("/productos")


public class ProductoController {
    @Autowired
    private ProductoRepositorio productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No está el producto del ID: "+ id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detailsProducto) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No está el producto del ID: "+ id));
        
        producto.setNombre(detailsProducto.getNombre());
        producto.setPrecio(detailsProducto.getPrecio());
        
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No está el producto del ID: "+ id));

        productoRepository.delete(producto);
        return "El producto con el ID: "+ id + " fue eliminado correctamente";
    }

    
}
