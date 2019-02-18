package com.designpattern.behavioral.command3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Throw away POC code DON'T USE in PRD
//This is invoker actually executing commands.
//starts a worker thread in change of executing commands
public class MailTaskRunner implements Runnable{

    private Thread runner;

    private List<Command> pendingCommands;

    private volatile boolean stop;

    private static final MailTaskRunner RUNNER = new MailTaskRunner();

    public static MailTaskRunner getInstance() {
        return RUNNER;
    }

    private MailTaskRunner() {
        this.pendingCommands = new LinkedList<>();
        this.runner = new Thread(this);
        this.runner.start();
    }

    //Run method takes pending command  and execute them
    @Override
    public void run() {
        while (true) {
            Command cmd = null;
            synchronized (pendingCommands) {
                if( pendingCommands.isEmpty()) {
                    try {
                        pendingCommands.wait();
                    }catch (InterruptedException e) {
                        System.out.println("Runner interrupted");
                        if(stop){
                            System.out.println("Runner stopping");
                            return;
                        }
                    }
                }else {
                    cmd = pendingCommands.remove(0);
                }
            }
            if(cmd == null)
                return;
            cmd.execute();
        }
    }

    public void addCommand(Command command){
        synchronized (pendingCommands){
            pendingCommands.add(command);
            pendingCommands.notifyAll();
        }
    }

    public void shutdown(){
        this.stop = true;
        this.runner.interrupt();
    }
}
