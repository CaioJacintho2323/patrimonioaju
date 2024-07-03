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
    @GetMapping("/setor")
    public ResponseEntity<List<Patrimonio>> getPatrimoniosBySetor(@RequestParam String setor) {
        List<Patrimonio> patrimonios = repository.findBySetor(setor);
        return ResponseEntity.ok(patrimonios);
    }

    @PutMapping()
    public ResponseEntity updatePatrimonio(@RequestBody @Validated ResquestPatrimonio data ){
        Optional<Patrimonio> patrimonio = repository.findById(data.id());
        return ResponseEntity.ok(patrimonio);

    }
}
