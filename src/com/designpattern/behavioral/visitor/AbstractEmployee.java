package com.designpattern.behavioral.visitor;

import java.util.Collection;
import java.util.Collections;

public abstract class AbstractEmployee implements Employee {

    private int performanceRating;

    private String name;

    private static int employeeIdCounter = 101;

    private int employeeId;

    public AbstractEmployee(String name) {
        this.name = name;
        this.employeeId = employeeIdCounter++;
    }

    @Override
    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int rating){
        this.performanceRating = rating;
    }

    public String getName() {
        return name;
    }

    public static int getEmployeeIdCounter() {
        return employeeIdCounter;
    }

    public Collection<Employee> getDirectReports() {
        return Collections.emptyList();
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }
}
