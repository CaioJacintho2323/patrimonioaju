package com.caiojacinthodev.patrimonio.domain.patrimonio;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "patrimonio")
@Entity(name = "patrimonio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patrimonio {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String numero_patrimonio;
    private String nome_patrimonio;
    private String setor;


    public Patrimonio(ResquestPatrimonio resquestPatrimonio){
        this.numero_patrimonio = resquestPatrimonio.numero_patrimonio();
        this.nome_patrimonio = resquestPatrimonio.nome_patrimonio();
        this.setor= resquestPatrimonio.setor();
    }
}
