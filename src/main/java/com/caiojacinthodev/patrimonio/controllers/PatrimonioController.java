package com.caiojacinthodev.patrimonio.controllers;

import com.caiojacinthodev.patrimonio.domain.patrimonio.PatriminioRepository;
import com.caiojacinthodev.patrimonio.domain.patrimonio.Patrimonio;
import com.caiojacinthodev.patrimonio.domain.patrimonio.ResquestPatrimonio;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patrimonio")
public class PatrimonioController {

    @Autowired
    private PatriminioRepository repository;

    @GetMapping
    public ResponseEntity getAllPatrimonio(){
       var allPatrimonios = repository.findAll();
       return ResponseEntity.ok(allPatrimonios);
    }

    @PostMapping
    public ResponseEntity registerPatriminio(@RequestBody @Validated ResquestPatrimonio data ){
        Patrimonio patrimonio = new Patrimonio(data);
        repository.save(patrimonio);
        return ResponseEntity.ok("Patromonio foi colocado no(a) " + patrimonio.getNome_patrimonio() +" destinado ao setor "+ patrimonio.getSetor());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Patrimonio> updatePatrimonio(@PathVariable String id, @RequestBody ResquestPatrimonio request) {
        Optional<Patrimonio> optionalPatrimonio = repository.findById(id);
        if (optionalPatrimonio.isPresent()) {
            Patrimonio patrimonio = optionalPatrimonio.get();
            patrimonio.setNumero_patrimonio(request.numero_patrimonio());
            patrimonio.setNome_patrimonio(request.nome_patrimonio());
            patrimonio.setSetor(request.setor());
            repository.save(patrimonio);
            return ResponseEntity.ok(patrimonio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatrimonio(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
