package com.designpattern.behavioral.momento;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Workflow {
    private String name;
    private List<String> steps;

    public Workflow(String name) {
        this.name = name;
        this.steps = new LinkedList<>();
    }

    public Workflow(String name, String... steps) {
        this.name = name;
        this.steps = new LinkedList<>();
        if(steps != null && steps.length > 0)
            Arrays.stream(steps).forEach(s -> this.steps.add(s));
    }

    public void addStep(String step){
        steps.add(step);
    }

    public void removeStep(String step){
        steps.remove(step);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSteps() {
        String[] temp = new String[steps.size()];
        return steps.toArray(temp);
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        //String.join(System.lineSeparator(), steps);
        StringBuilder builder = new StringBuilder("Workflow [name=");
        builder.append(name).append("] \n BEGIN -> ");
        for(String step : steps)
            builder.append(step).append(" -> ");
        return builder.toString();
    }
}
