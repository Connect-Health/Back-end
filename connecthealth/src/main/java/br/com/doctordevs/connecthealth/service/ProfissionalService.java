package br.com.doctordevs.connecthealth.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.doctordevs.connecthealth.model.Profissional;
import br.com.doctordevs.connecthealth.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

    @Autowired
    ProfissionalRepository profissionalRepository;

    public List<Profissional> getAllProfissional() {
        List<Profissional> profissional = new ArrayList<Profissional>();
        profissionalRepository.findAll().forEach(profissional1 -> profissional.add(profissional1));
        return profissional;
    }

    public Profissional getProfissional(int profissionalId) {
        return profissionalRepository.findById(profissionalId).get();
    }

    public void delete(int profissionalId) {
        profissionalRepository.deleteById(profissionalId);
    }

    public void save(Profissional profissional) {
        profissionalRepository.save(profissional);  
    }

    public void update(Profissional profissional, int profissionalId)   
    {  
        profissionalRepository.save(profissional);  
    }  
}
