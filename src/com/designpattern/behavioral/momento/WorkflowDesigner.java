package com.designpattern.behavioral.momento;

//Originator
public class WorkflowDesigner {
    private Workflow workflow;

    public void createWorkflow(String name){
        workflow = new Workflow(name);
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public Memento getMemento(){
        if(workflow == null){
            return new Memento();
        }
        return new Memento(workflow.getName(), workflow.getSteps());
    }

    public void setMemento(Memento memento){
        if(memento.isEmpty()){
            this.workflow = null;
        }else {
            this.workflow = new Workflow(memento.name, memento.getSteps());
        }
    }

    public void addStep(String step){
        workflow.addStep(step);
    }
    public void removeStep(String step){
        workflow.removeStep(step);
    }

    public void print(){
        System.out.println(workflow);
    }

    //Memento
    public class Memento {
        private String steps[];
        private String name;

        public Memento() {
        }

        private Memento(String name, String[] steps) {
            this.name = name;
            this.steps = steps;
        }

        private String[] getSteps(){
            return steps;
        }

        private String getName(){
            return name;
        }

        private boolean isEmpty(){
            return  this.getSteps() == null && this.getName() == null;
        }
    }
}
