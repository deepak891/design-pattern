package com.designpattern.behavioral.momento;


import java.util.LinkedList;

public class Client {
    public static void main(String[] args) {
        WorkflowDesigner designer = new WorkflowDesigner();
        LinkedList<WorkflowCommand> commands = runCommands(designer);
        designer.print();
        undoLastCommand(commands);
        designer.print();
        undoLastCommand(commands);
        designer.print();
        undoLastCommand(commands);
        designer.print();
        undoLastCommand(commands);
        designer.print();
    }

    private static void undoLastCommand(LinkedList<WorkflowCommand> commands) {
        if(!commands.isEmpty())
            commands.removeLast().undo();
    }

    private static LinkedList<WorkflowCommand> runCommands(WorkflowDesigner designer) {
        LinkedList<WorkflowCommand> commands = new LinkedList<>();

        WorkflowCommand cmd = new CreateCommand(designer, "Leave workflow");
        commands.add(cmd);
        cmd.execute();
        cmd = new AddStepCommand(designer, "Create leave application");
        commands.add(cmd);
        cmd.execute();
        cmd = new AddStepCommand(designer, "Submit application");
        commands.add(cmd);
        cmd.execute();
        cmd = new AddStepCommand(designer, "Application approved");
        commands.add(cmd);
        cmd.execute();
        return commands;
    }
}
