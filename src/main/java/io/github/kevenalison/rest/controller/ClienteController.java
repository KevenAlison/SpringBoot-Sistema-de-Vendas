package io.github.kevenalison.rest.controller;

import io.github.kevenalison.domain.entity.Cliente;
import io.github.kevenalison.domain.repository.ClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteController {

    private ClientesRepository clientesRepository;
    public ClienteController(ClientesRepository cliente){
        clientesRepository = cliente;
    }

    //Adicionar cliente
    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity save( @RequestBody Cliente cliente){
        Cliente clienteSalvo = clientesRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

 
}
