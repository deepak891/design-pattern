package com.designpattern.behavioral.command;

/**
 * Command Pattern : We can encapsulate method invocation, it encapsulate a request as an object
 *
 * Good : The object invoking the computation knows nothing about implementation
 *
 * It has 4 components, Command, receiver, invoker and client
 *
 *  Command : Knows about the receiver, and execute a method on receiver
 *  Receiver : does the work!
 *  invoker : knows nothing about implementation e.g switching button can run car or turn on light or launch nuclear bomb
 *  client : Decides which command to execute at which point, to execute a command it pass the command object to receiver
 *
 */
public class App {

    public static void main(String[] args) {
        Switcher switcher = new Switcher();

        Light light = new Light();
        TurnOnCommand turnOnCommand = new TurnOnCommand(light);
        TurnOffCommand turnOffCommand = new TurnOffCommand(light);

        switcher.addCommands(turnOffCommand);
        switcher.addCommands(turnOnCommand);

        switcher.executeCommands();
    }


}
