package com.designpattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

//Mediator
public class UIMediator {

    private List<UIControl> colleagues;

    public UIMediator() {
        this.colleagues = new ArrayList<>();
    }

    public void registerControls(UIControl control) {
        colleagues.add(control);
    }

    public void valueChanged(UIControl control){
        colleagues.stream().filter(c -> c!=control).forEach(c -> c.controlChanged(control));
    }
}
