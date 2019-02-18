package com.designpattern.behavioral.command2;

public class TaskSolver implements Command {

    private Task task;

    public TaskSolver(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        task.solveProblem();
    }
}
