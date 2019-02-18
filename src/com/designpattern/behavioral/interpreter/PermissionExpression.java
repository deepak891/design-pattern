package com.designpattern.behavioral.interpreter;

//Abstract expression
public interface PermissionExpression {

    boolean interpret(User user);
}
