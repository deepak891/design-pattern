package com.designpattern.behavioral.momento;

public class RemoveStepCommand extends AbstractWorkflowCommand {
    private String step;
    public RemoveStepCommand(WorkflowDesigner receiver, String step) {
        super(receiver);
        this.step = step;
    }

    @Override
    public void execute() {
        memento = receiver.getMemento();
        receiver.removeStep(step);
    }
}
