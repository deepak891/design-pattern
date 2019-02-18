package com.designpattern.behavioral.template2;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        Order order = new Order("1001");
        order.addItem("Soda ", 2.50);
        order.addItem("Sandwitch ", 5.50);
        order.addItem("Pizza", 10.5);

        OrderPrinter printer = new HtmlPrinter();
        printer.printOrder(order, "10001.txt");
    }
}
