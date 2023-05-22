package br.com.doctordevs.connecthealth.repository;
import br.com.doctordevs.connecthealth.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository  extends JpaRepository <Paciente, Integer> {

}
