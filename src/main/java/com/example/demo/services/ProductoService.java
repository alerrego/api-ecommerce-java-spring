package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Producto;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    public Producto agregaProducto(Producto p){
        return productoRepository.save(p);
    }

    public Producto obtenerProductoByID(Long id){
        return productoRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("No se encontro ningún producto con el ID: "+id));
    }

    public Producto modificarProducto(Long id,Producto p){
        Producto productoViejo = productoRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("No se encontro ningún producto con el ID: "+id));

        productoViejo.setDescripcion(p.getDescripcion());
        productoViejo.setNombre(p.getNombre());
        productoViejo.setPrecioUnitario(p.getPrecioUnitario());
        productoViejo.setStock(p.getStock());

        return productoRepository.save(productoViejo);
    }

    public void eliminarProductoByID(Long id){
       productoRepository.deleteById(id);
    }


}
