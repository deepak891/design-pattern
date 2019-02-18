package com.designpattern.behavioral.interpreter;

public class Client {
    public static void main(String[] args) {
        Report report = new Report("Cash flow report", "FINANCE_ADMIN OR ADMIN");
        ExpressionBuilder builder =  new ExpressionBuilder();
        PermissionExpression expression = builder.build(report);
        System.out.println(expression);

        User user = new User("Deepak", "ADMIN");

        System.out.println(" User access report :" + expression.interpret(user));
    }
}
