package com.designpattern.structural.facade.email;

public class TemplateFactory {
    public static Template crateTemplateFor(Template.TemplateType type) {
        switch (type){
            case EMAIL:
                return new OrderEmailTemplate();
            default:
                throw new IllegalArgumentException("Unknown template");
        }
    }
}
