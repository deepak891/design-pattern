package com.designpattern.behavioral.command3;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        EWSService service = new EWSService();

        Command c1 = new AddMemberCommand("a@a.com", "spam", service);
        MailTaskRunner.getInstance().addCommand(c1);

        Command c2 = new AddMemberCommand("b@b.com", "spam", service);
        MailTaskRunner.getInstance().addCommand(c2);

        Thread.sleep(1000);
        MailTaskRunner.getInstance().shutdown();

    }
}
