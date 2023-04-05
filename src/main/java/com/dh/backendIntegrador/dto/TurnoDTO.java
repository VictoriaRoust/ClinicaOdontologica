package com.dh.backendIntegrador.dto;

import java.time.LocalDate;

public class TurnoDTO {
    private Long id;
    private LocalDate fecha;
    private Long pacienteId;
    private String nombrePac, apellidoPac;
    private Long odontologoId;
    private String nombreOdo, apellidoOdo;


    public TurnoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getApellidoPac() {
        return apellidoPac;
    }

    public void setApellidoPac(String apellidoPac) {
        this.apellidoPac = apellidoPac;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public String getNombreOdo() {
        return nombreOdo;
    }

    public void setNombreOdo(String nombreOdo) {
        this.nombreOdo = nombreOdo;
    }

    public String getApellidoOdo() {
        return apellidoOdo;
    }

    public void setApellidoOdo(String apellidoOdo) {
        this.apellidoOdo = apellidoOdo;
    }

    public TurnoDTO(Long id, LocalDate fecha, Long pacienteId, String nombrePac, String apellidoPac, Long odontologoId, String nombreOdo, String apellidoOdo) {
        this.id = id;
        this.fecha = fecha;
        this.pacienteId = pacienteId;
        this.nombrePac = nombrePac;
        this.apellidoPac = apellidoPac;
        this.odontologoId = odontologoId;
        this.nombreOdo = nombreOdo;
        this.apellidoOdo = apellidoOdo;
    }
    public TurnoDTO(LocalDate fecha, Long pacienteId, String nombrePac, String apellidoPac, Long odontologoId, String nombreOdo, String apellidoOdo) {
        this.fecha = fecha;
        this.pacienteId = pacienteId;
        this.nombrePac = nombrePac;
        this.apellidoPac = apellidoPac;
        this.odontologoId = odontologoId;
        this.nombreOdo = nombreOdo;
        this.apellidoOdo = apellidoOdo;
    }

}
