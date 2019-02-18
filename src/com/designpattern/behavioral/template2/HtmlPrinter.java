package com.designpattern.behavioral.template2;

import java.util.Map;

public class HtmlPrinter extends OrderPrinter {
    @Override
    protected String start() {
        return "<html> <head> <title> Order Details</title></head><body>";
    }

    @Override
    protected String formatOrderNumber(Order order) {
        return "<h1>Order #" + order.getId() + "<h1>";
    }

    @Override
    protected String formatItems(Order order) {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String, Double> entry : order.getItems().entrySet()){
            builder.append("<li>" + entry.getKey() + " $ " + entry.getValue() + "</li>");
        }
        builder.append("</ul></p>");
        return builder.toString();
    }

    @Override
    protected String formatTotal(Order order) {
        return "<br/><hr/> <h3> Total :$" + order.getTotal() + "</h3>";
    }

    @Override
    protected String end() {
        return "</body></html>";
    }
}
