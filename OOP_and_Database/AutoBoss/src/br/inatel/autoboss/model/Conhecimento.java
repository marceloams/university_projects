/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.autoboss.model;

/**
 *
 * @author Sinara
 */

//classe para declarar conhecimento e seus atributos
public class Conhecimento {
    private String nomeConhecimento;
    
    public Conhecimento(String con){
        nomeConhecimento = con;
    }

    public String getNomeConhecimento() {
        return nomeConhecimento;
    }

    public void setNomeConhecimento(String nomeConhecimento) {
        this.nomeConhecimento = nomeConhecimento;
    }
}
