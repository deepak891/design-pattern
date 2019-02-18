package com.designpattern.structural.adapter.classadapter;

public class Main {
    public static void main(String[] args) {
        /** using class adapter, two way adapter */
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        populateEmployeeData(adapter);
        BusinessCardDesigner designer = new BusinessCardDesigner();
        String card = designer.designCard(adapter);
        System.out.println(card);

        /** using object adapter, two way adapter */
        System.out.println("######################################################################");
        Employee employee = new Employee();
        populateEmployeeData(employee);
        EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
        card = designer.designCard(objectAdapter);
        System.out.println(card);
    }

    private static void populateEmployeeData(Employee employee) {
        employee.setFullName("Deepak Bhagat");
        employee.setJobTitle("AVP");
        employee.setOfficeLocation("Singapore");
    }
}
