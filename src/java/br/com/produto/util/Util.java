/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author vinicius
 */
public class Util {
    
     /**
     * Metodo que mostra mensagem via growl
     *
     * @param severity
     * @param titulo
     * @param mensagem
     */
    public static void mostrarMensagem(FacesMessage.Severity severity, String titulo, String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, titulo, mensagem));
    }
    
     /**
     * Método que mostra mensagem de sucesso
     */
    public static void mostrarMensagemSucesso(String titulo, String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem));
    }

    /**
     * Método que mostra mensagem de alerta
     */
    public static void mostrarMensagemAlerta(String titulo, String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensagem));
    }

    /**
     * Método que mostra mensagem de erro
     */
    public static void mostrarMensagemErro(String titulo, String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensagem));
    }
}
