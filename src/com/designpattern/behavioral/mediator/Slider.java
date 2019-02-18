package com.designpattern.behavioral.mediator;

public class Slider extends javafx.scene.control.Slider implements UIControl {

    private UIMediator mediator;
    private boolean mediatedUpdate;

    public Slider(UIMediator mediator) {
        this.mediator = mediator;
        setMin(0);
        setMax(50);
        setBlockIncrement(5);
        this.mediator.registerControls(this);
        this.valueProperty().addListener((v, n, o) -> {
            if( !mediatedUpdate)
                this.mediator.valueChanged(this);
        });
    }

    @Override
    public void controlChanged(UIControl control) {
        mediatedUpdate = true;
        setValue(Double.valueOf(control.getControlValue()));
        mediatedUpdate = false;
    }

    @Override
    public String getControlValue() {
        return Double.toString(getValue());
    }

    @Override
    public String getControlName() {
        return "Slider";
    }
}
