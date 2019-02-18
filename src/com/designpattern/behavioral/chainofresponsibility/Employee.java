package com.designpattern.behavioral.chainofresponsibility;

//Abstract handler
public abstract class Employee implements LeaveApprover{

    private String role;
    //Store successor
    private LeaveApprover nextApprover;

    public Employee(String role, LeaveApprover successor) {
        this.role = role;
        this.nextApprover = successor;
    }

    //We check if we can process the request. If not then we pass to next handler
    @Override
    public void processLeaveApplication(LeaveApplication application) {
        if(!processRequest(application) && nextApprover != null) {
            nextApprover.processLeaveApplication(application);
        }
    }

    protected abstract boolean processRequest(LeaveApplication application);

    @Override
    public String getApproverRole() {
        return role;
    }
}
