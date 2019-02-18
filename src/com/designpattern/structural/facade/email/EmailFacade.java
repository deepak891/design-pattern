package com.designpattern.structural.facade.email;

import com.designpattern.structural.facade.Order;

//Facade provides simple method for client to use
public class EmailFacade {

    public boolean sendOrderEmail(Order order){
        Template template = TemplateFactory.crateTemplateFor(Template.TemplateType.EMAIL);
        Stationary stationary = StationaryFactory.createStationary();
        Email email = new Email.Builder()
                .withStationary(stationary)
                .withTemplate(template)
                .forObject(order)
                .build();

        Mailer mailer = Mailer.getMailer();
        return mailer.send(email);
    }
}
