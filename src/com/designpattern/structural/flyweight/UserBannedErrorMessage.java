package com.designpattern.structural.flyweight;

import java.time.Duration;

//Unshared concrete flyweight
public class UserBannedErrorMessage implements ErrorMessage {

    //All state is defined here
    private String caseId;

    private String remark;

    private Duration banDuration;

    private String msg;

    public UserBannedErrorMessage(String caseId) {
        //Load case info from DB.
        this.caseId = caseId;
        remark = "You violated terms of use";
        banDuration = Duration.ofDays(2);
        msg = "You are Banned. Sorry. \n More information: \n";
        msg += caseId + "\n";
        msg += remark + "\n";
        msg += "Banned for " + banDuration.toHours() + "Hours";
    }

    //We ignore the extrinsic state argument
    @Override
    public String getText(String code) {
        return msg;
    }

    public String getCaseNo() {
        return caseId;
    }
}
