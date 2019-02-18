package com.designpattern.behavioral.visitor;

import java.util.Collection;

public interface Employee {

    int getPerformanceRating();

    void setPerformanceRating();

    Collection<Employee> getDirectReport();

    int getEmployeeId();
}
