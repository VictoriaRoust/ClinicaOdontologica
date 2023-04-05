package com.dh.backendIntegrador.controller;


import com.dh.backendIntegrador.entity.Odontologo;
import com.dh.backendIntegrador.exception.ResourceNotFoundException;
import com.dh.backendIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {


    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos (){
        return ResponseEntity.ok(odontologoService.listarOdontologos()) ;
    }
    @DeleteMapping
    public ResponseEntity<String> eliminarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        Optional<Odontologo> resultado = odontologoService.buscarOdontologo(odontologo.getId());
        if (resultado.isPresent()) {
            odontologoService.eliminarOdontologo(odontologo.getId());
            return ResponseEntity.ok("odontologo eliminado");
        } else {
            throw new ResourceNotFoundException("el odontologo no se pudo eliminar");
        }
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) throws ResourceNotFoundException{

        Optional<Odontologo> resultado = odontologoService.buscarOdontologo(id);
        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            throw  new ResourceNotFoundException("no se se pudo realizar la busqueda del odontologo");
        }
    };
    @PutMapping
    public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> Odontobuscado = odontologoService.buscarOdontologo(odontologo.getId());
        if (Odontobuscado.isPresent()) {

            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok("Se actualizo el odontologo");
        } else {
            return ResponseEntity.badRequest().body("No se puedo actualizar los datos del odontologo");
        }
    }

}
