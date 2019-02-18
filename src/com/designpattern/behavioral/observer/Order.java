package com.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

//A concrete subject
public class Order {
    private String id;
    private int count;
    private double itemCost;
    private double discount;
    private double shippingCost;

    private List<Observable> observableList = new ArrayList<>();

    public Order(String id) {
        this.id = id;
    }

    public void addItem(double price){
        itemCost += price;
        count++;
        observableList.forEach( o -> o.updated(this));
    }

    public void attach(Observable observable){
        observableList.add(observable);
    }

    public void detach(Observable observable) {
        observableList.remove(observable);
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getTotal() {
        return itemCost - discount + shippingCost;
    }
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", count=" + count +
                ", itemCost=" + itemCost +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                ", observableList=" + observableList +
                '}';
    }
}
