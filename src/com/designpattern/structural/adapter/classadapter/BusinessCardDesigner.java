package com.designpattern.structural.adapter.classadapter;

/**
 * Client interface wich require customer interface
 */
public class BusinessCardDesigner {
    public String designCard(Customer customer) {
        String card = "";
        card += customer.getName();
        card += "\n" + customer.getDesignation();
        card += "\n" + customer.getAddress();
        return card;
    }
}
