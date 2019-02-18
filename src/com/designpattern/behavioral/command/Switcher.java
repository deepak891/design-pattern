package com.designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    public List<Command> commands ;

    public Switcher() {
        commands = new ArrayList<>();
    }

    public void addCommands(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for(Command c : commands) {
            c.execute();
        }
    }

}
