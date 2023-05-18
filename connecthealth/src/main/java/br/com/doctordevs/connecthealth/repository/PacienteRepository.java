package br.com.doctordevs.connecthealth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.doctordevs.connecthealth.model.Paciente;


public interface PacienteRepository  extends JpaRepository <Paciente, Integer> {
    
}
