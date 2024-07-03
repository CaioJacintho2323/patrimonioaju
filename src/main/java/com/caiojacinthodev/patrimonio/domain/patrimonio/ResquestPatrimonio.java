package com.caiojacinthodev.patrimonio.domain.patrimonio;

import org.antlr.v4.runtime.misc.NotNull;

public record ResquestPatrimonio( String id, @NotNull  String numero_patrimonio, @NotNull String nome_patrimonio, @NotNull String setor) {

}
