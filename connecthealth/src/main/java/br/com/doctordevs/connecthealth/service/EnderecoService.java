package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.doctordevs.connecthealth.model.Endereco;
import br.com.doctordevs.connecthealth.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEndereco() {
        List<Endereco> endereco = new ArrayList<Endereco>();
        enderecoRepository.findAll().forEach(endereco1 -> endereco.add(endereco1));
        return endereco;
    }

    public Endereco getEndereco(int enderecoId) {
        return enderecoRepository.findById(enderecoId).get();
    }

    public void delete(int enderecoId) {
        enderecoRepository.deleteById(enderecoId);
    }

    public void save(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void update(Endereco endereco, int enderecoId) {
        enderecoRepository.save(endereco);
    }

}
