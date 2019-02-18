package com.designpattern.behavioral.momento;

public interface WorkflowCommand {
    void execute();
    void undo();
}
