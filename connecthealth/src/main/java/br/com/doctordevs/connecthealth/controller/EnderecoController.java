package br.com.doctordevs.connecthealth.controller;

import br.com.doctordevs.connecthealth.model.Endereco;
import br.com.doctordevs.connecthealth.service.EnderecoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*")
public class EnderecoController {
        @Autowired
        private EnderecoService enderecoService;
    
        @GetMapping
        public List<Endereco> getAllEndereco(){
            return enderecoService.getAllEndereco();
        }
    
        @GetMapping("/endereco/{enderecoId}")
        public Endereco getEndereco(@PathVariable("enderecoId") int enderecoId){
            return enderecoService.getEndereco(enderecoId);
    
        }
    
        @DeleteMapping("/endereco/{enderecoId}")
        private void deleteEndereco(@PathVariable("enderecoId") int enderecoId)
        {
            enderecoService.delete(enderecoId);
        }
    
        @PostMapping
        private int saveEndereco(@RequestBody Endereco endereco)
        {
            enderecoService.save(endereco);
            return endereco.getEnderecoId();
        }
    
        @PutMapping
        private Endereco update(@RequestBody Endereco endereco)
        {
            enderecoService.save(endereco);
            return endereco;
        }
}

