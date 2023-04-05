package com.dh.backendIntegrador.controller;

import com.dh.backendIntegrador.dto.TurnoDTO;
import com.dh.backendIntegrador.exception.BadRequestException;
import com.dh.backendIntegrador.exception.ResourceNotFoundException;
import com.dh.backendIntegrador.respository.PacienteRepository;
import com.dh.backendIntegrador.service.OdontologoService;
import com.dh.backendIntegrador.service.PacienteService;
import com.dh.backendIntegrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService  odontologoService;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService  odontologoService,
                           PacienteRepository pacienteRepository) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {

        ResponseEntity<TurnoDTO> respuesta;
        if (pacienteService.buscarPaciente(turnoDTO.getPacienteId()).isPresent()&&odontologoService.buscarOdontologo(turnoDTO.getOdontologoId()).isPresent()){
            respuesta=ResponseEntity.ok(turnoService.guardarTurno(turnoDTO));
        } else {

            throw new BadRequestException("No se puede cargar el turno porque no existe o el odontologo o el paciente en la Base de Datos");
        }
        return respuesta;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<TurnoDTO> resultado = turnoService.buscarTurno(id);
        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            throw new ResourceNotFoundException("Se realizo la busqueda del turno: "+id+", sin exito");
        }
    }
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarTurnos() {
        return ResponseEntity.ok(turnoService.buscarTodosTurnos());
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity <String> eliminarTurno (@PathVariable Long id){
        Optional<TurnoDTO> resultado = turnoService.buscarTurno(id);
        if (resultado.isPresent()) {
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se eliminó el turno correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se puede eliminar el turno");
        }
    }

    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody TurnoDTO turno) {
//        ResponseEntity<TurnoDTO> buscado;

        if(turnoService.buscarTurno(turno.getId()).isPresent()){
            if (pacienteService.buscarPaciente(turno.getPacienteId()).isPresent()&&
                    odontologoService.buscarOdontologo(turno.getOdontologoId()).isPresent()
            ){ turnoService.actualizarTurno(turno);
                return ResponseEntity.ok("Se actualizó el turno");
            } else{
                return ResponseEntity.badRequest().body("Error al actualizar el turno.");
            }
        }
        else{
            return ResponseEntity.badRequest().body("El turno no existe en la ");
        }
    }
}

