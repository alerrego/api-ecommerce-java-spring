package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Producto;
import com.example.demo.services.ProductoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired //SIEMPRE ACORDARSE DEL AUTOWIRED, SINO NO EXISTE LA INYECCION DE DEPENDENCIAS
    ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/producto/{id}")
    public Producto buscarProductoByID(@PathVariable Long id) {
        return productoService.obtenerProductoByID(id);
    }

    @PostMapping("/producto")
    public Producto agregarProducto(@RequestBody Producto p){
        return productoService.agregaProducto(p);
    }

    @PutMapping("/producto/{id}")
    public Producto modificarProductoByID(@PathVariable Long id, @RequestBody Producto p) {
        return productoService.modificarProducto(id, p);
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Map<String,Object>> eliminarProductoByID(@PathVariable Long id){
        productoService.eliminarProductoByID(id);
        Map<String,Object> body = new HashMap<String,Object>();
        body.put("code", HttpStatus.OK);
        body.put("message","El producto: "+id+" fue eliminado correctamente.");
        return ResponseEntity.ok().body(body);
    } 
    
}
