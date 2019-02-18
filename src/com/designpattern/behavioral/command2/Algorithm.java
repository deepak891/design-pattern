package com.designpattern.behavioral.command2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Algorithm {

    private BlockingQueue<Command> commands;

    public Algorithm() {
        this.commands = new ArrayBlockingQueue<>(10);
    }

    public void produce() {
        try {
            for(int i = 0 ; i < 10 ; i++) {
                commands.put( new TaskSolver(new Task(i+1)));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void consume() {
        try{
            for(int i = 0 ; i < 10 ; i++) {
                Thread.sleep(1000);
                commands.take().execute();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
