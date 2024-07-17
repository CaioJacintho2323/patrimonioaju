package com.caiojacinthodev.patrimonio.domain.patrimonio;

public enum Setor {
    DTI("dti"),
    BENEFICIO("beneficio"),
    DIVISAO_DE_INVESTIMENTO("divisao_de_investimento"),
    DIVISAO_DE_APOIO("divisao_de_apoio"),
    ATENDIMENTO("atendimento"),
    JURIDICO("juridico"),;

    private String setor;

    Setor(String setor) {
        this.setor = setor;
    }
    public String getSetor(){
        return setor;
    }
}
