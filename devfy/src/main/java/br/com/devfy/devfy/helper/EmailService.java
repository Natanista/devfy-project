package br.com.devfy.devfy.helper;

import br.com.devfy.devfy.entity.Notificacao;

public class EmailService implements Notificacao {

    public void notificarEmpresa(){
        System.out.println("Gmail: Atenção, ocorreu uma nova ação em sua empresa!");
    }

    public  void notificarCliente(){
        System.out.println("Gmail: Atenção cliente! Ocorreu uma nova ação relacionada a você!");
    }
}
