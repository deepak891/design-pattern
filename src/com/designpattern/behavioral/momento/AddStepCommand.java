package com.designpattern.behavioral.momento;

public class AddStepCommand extends AbstractWorkflowCommand {
    private String step;

    public AddStepCommand(WorkflowDesigner designer, String step) {
        super(designer);
        this.step = step;
    }

    @Override
    public void execute() {
        memento = receiver.getMemento();
        receiver.addStep(step);
    }
}
