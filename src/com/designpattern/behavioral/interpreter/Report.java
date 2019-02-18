package com.designpattern.behavioral.interpreter;

public class Report {
    private String name;
    //"NOT ADMIN", "FINANCE USER AND ADMIN"
    private String permission;

    public Report(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }
}
