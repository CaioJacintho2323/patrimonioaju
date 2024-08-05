package com.caiojacinthodev.patrimonio.Exception;

public class PatrimonioDuplicado extends RuntimeException{
    public PatrimonioDuplicado(){
        super("patrimonio duplicado");
    }
    public PatrimonioDuplicado(String mensagem){
        super(mensagem);
    }
}
