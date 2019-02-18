package com.designpattern.behavioral.interpreter;

import java.util.Stack;
import java.util.StringTokenizer;

//Parse and build abstract syntax tree
public class ExpressionBuilder {

    private Stack<PermissionExpression> permissions = new Stack<>();

    private Stack<String> operators = new Stack<>();

    public PermissionExpression build(Report report) {
        parse(report.getPermission());
        buildExpression();
        if(permissions.size() > 1 || !operators.isEmpty()) {
            System.out.println("ERROR!");
        }
        return permissions.pop();
    }


    private void buildExpression() {
        while (!operators.isEmpty()) {
            String operator = operators.pop();
            PermissionExpression perm1;
            PermissionExpression perm2;

            PermissionExpression exp1;
            switch (operator) {
                case "not":
                    perm1 = permissions.pop();
                    exp1 = new NotExpression(perm1);
                    break;
                case "and":
                    perm1 = permissions.pop();
                    perm2 = permissions.pop();
                    exp1 = new AndExpression(perm1, perm2);
                    break;
                case "or":
                    perm1 = permissions.pop();
                    perm2 = permissions.pop();
                    exp1 = new OrExpression(perm1, perm2);
                    break;
                    default:
                        throw  new IllegalArgumentException("Unknown operation : " + operator);
            }
            permissions.push(exp1);
        }
    }

    private void parse(String permission) {
        StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());
        while (tokenizer.hasMoreTokens()) {
            String token;
            switch (token = tokenizer.nextToken()) {
                case "and" :
                    operators.push(token);
                    break;
                case "or":
                    operators.push(token);
                    break;
                case "not":
                    operators.push(token);
                    break;
                default:
                    permissions.push(new Permission(token));
                    break;
            }

        }
    }
}
