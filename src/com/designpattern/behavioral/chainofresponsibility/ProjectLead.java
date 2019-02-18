package com.designpattern.behavioral.chainofresponsibility;

//A Concrete handler
public class ProjectLead extends Employee {

    public ProjectLead(LeaveApprover successor) {
        super("Project Lead", successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        //type is sick leave and duration is less then or equal to 2 days
        if(application.getType() == LeaveApplication.Type.SICK) {
            if(application.getNumberOfDays() <= 2) {
                application.approve(getApproverRole());
                return true;
            }
        }
        return false;
    }
}
