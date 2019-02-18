package com.designpattern.behavioral.chainofresponsibility;

//This represent a handler in chain of responsibility
public interface LeaveApprover {

    void processLeaveApplication(LeaveApplication application);

    String getApproverRole();
}
