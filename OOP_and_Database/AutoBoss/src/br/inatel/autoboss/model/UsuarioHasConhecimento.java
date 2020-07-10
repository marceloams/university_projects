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

//classe para declarar o relacionamento usuariohasconhecimento
public class UsuarioHasConhecimento {
    private int id_usuario;
    private int id_conhecimento;

    public UsuarioHasConhecimento(int usuario, int conhecimento) {
        id_usuario = usuario;
        id_conhecimento = conhecimento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_conhecimento() {
        return id_conhecimento;
    }

    public void setId_conhecimento(int id_conhecimento) {
        this.id_conhecimento = id_conhecimento;
    }   
}
