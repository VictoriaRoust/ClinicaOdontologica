package com.dh.backendIntegrador.respository;

import com.dh.backendIntegrador.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {
//    Optional<Paciente> findByEmail(String email);

}
