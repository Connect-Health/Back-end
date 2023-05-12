package br.com.doctordevs.connecthealth.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.doctordevs.connecthealth.model.Paciente;

@Repository
public interface PacienteRepository  extends CrudRepository <Paciente, Integer> {
    
}
