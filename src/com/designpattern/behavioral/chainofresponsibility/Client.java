package com.designpattern.behavioral.chainofresponsibility;

import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {
        //We get hold of request
        LeaveApplication application = LeaveApplication.getBuilder()
                .withType(LeaveApplication.Type.PTO)
                .from(LocalDate.now())
                .to(LocalDate.of(2019, 1, 10))
                .build();

        System.out.println(application);
        //We get hold of first object chain
        Employee approver = setupApprover();
        //We pass the request to first object chain
        approver.processLeaveApplication(application);
        //We see if the request was handled or not
        System.out.println(application);
    }

    //Here we setup chain of responsibility
    private static Employee setupApprover() {
        Director director  = new Director(null);
        Manager manager = new Manager(director);
        ProjectLead lead = new ProjectLead(manager);
        return lead;
    }
}
