package br.com.doctordevs.connecthealth.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.doctordevs.connecthealth.model.Paciente;
import br.com.doctordevs.connecthealth.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> getAllPaciente() {
        List<Paciente> paciente = new ArrayList<Paciente>();
        pacienteRepository.findAll().forEach(paciente1 -> paciente.add(paciente1));
        return paciente;
    }

    public Paciente getPaciente(int pacienteId) {
        return pacienteRepository.findById(pacienteId).get();
    }

    public void delete(int pacienteId) {
        pacienteRepository.deleteById(pacienteId);
    }

    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);  
    }

    public void update(Paciente paciente, int pacienteId)   
    {  
        pacienteRepository.save(paciente);  
    }  
}
