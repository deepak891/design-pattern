package com.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

//Flyweight factory. Returns shared flyweight based on some key
public class ErrorMessageFactory {

    //This server as a key for getting flyweight instance.
    public enum ErrorType {
        GENERIC_SYSTEM_ERROR,
        PAGE_NOT_FOUND_ERROR,
        SERVER_ERROR
    }

    private static ErrorMessageFactory factory = new ErrorMessageFactory();

    private Map<ErrorType, SystemErrorMessage> errorMessages = new HashMap<>();

    private ErrorMessageFactory(){
        errorMessages.put(ErrorType.GENERIC_SYSTEM_ERROR,
                new SystemErrorMessage("A generic error of type $errorCode occurred. Please refer to :\n",
                        "http://google.com/q="));
        errorMessages.put(ErrorType.PAGE_NOT_FOUND_ERROR,
                new SystemErrorMessage("Page not found  of type $errorCode occurred. Please refer to :\n",
                        "http://google.com/q="));
    }

    public SystemErrorMessage getError(ErrorType type) {
        return errorMessages.get(type);
    }

    public static ErrorMessageFactory getInstance(){
        return factory;
    }

    public UserBannedErrorMessage getUserBannedMessage(String caseId) {
        return new UserBannedErrorMessage(caseId);
    }

}
