/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WebPage.writer.controlador;

import com.WebPage.writer.modelo.audiolibroModelo;
import com.WebPage.writer.repositorio.audiolibroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})

@RequestMapping("/api/audiolibro")
public class audiolibroControlador {
    
    /// Variable de interfaz de Modelo
    @Autowired
    private audiolibroRepositorio aud;
    
    /// Procedimiento guardar
    @PostMapping("/guardar")
    public audiolibroModelo guardarAudiolibro(@Validated @RequestBody audiolibroModelo varA){
        return aud.insert(varA);
    }
    
    ///Procedimiento consulta general
    @GetMapping("/consultar")
    public List<audiolibroModelo> consultarAudiolibro(){
        return aud.findAll();
    }
    
    /// Procedimiento actualizar
    @PutMapping("/actualizar/{id}")
    public audiolibroModelo actualizarAudiolibro(@PathVariable String id, @Validated @RequestBody audiolibroModelo varE){
        return aud.save(varE);
    }
    
    /// Procedimiento eliminar audiolibro
    @DeleteMapping("/eliminar/{id}")
    public void eliminarAudiolibro(@PathVariable String id){
    }
}
