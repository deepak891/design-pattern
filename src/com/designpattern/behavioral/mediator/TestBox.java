package com.designpattern.behavioral.mediator;

import javafx.scene.control.TextField;

public class TestBox extends TextField implements UIControl{

    private UIMediator mediator;
    private boolean mediatedUpdate;
    public TestBox(UIMediator mediator) {
        this.mediator = mediator;
        this.setText("Text box");
        this.mediator.registerControls(this);

        this.textProperty().addListener( (v, o, n) -> {
            if(!mediatedUpdate)
                this.mediator.valueChanged(this);
        });
    }

    @Override
    public void controlChanged(UIControl control) {
        this.mediatedUpdate = true;
        this.setText(control.getControlValue());
        this.mediatedUpdate = false;

    }

    @Override
    public String getControlValue() {
        return getText();
    }

    @Override
    public String getControlName() {
        return "Textbox";
    }


}
