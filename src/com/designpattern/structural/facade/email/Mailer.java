package com.designpattern.structural.facade.email;

public class Mailer {

    private static Mailer MAILER = new Mailer();

    private Mailer(){}

    public static Mailer getMailer(){
        return MAILER;
    }

    public boolean send(Email email){
        return true;
    }
}
