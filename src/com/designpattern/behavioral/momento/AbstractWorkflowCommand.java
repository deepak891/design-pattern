package com.designpattern.behavioral.momento;

public abstract class AbstractWorkflowCommand implements WorkflowCommand {

    protected WorkflowDesigner.Memento memento;
    protected WorkflowDesigner receiver;

    public AbstractWorkflowCommand(WorkflowDesigner receiver) {
        this.receiver = receiver;
    }

    @Override
    public void undo() {
        receiver.setMemento(memento);
    }
}
