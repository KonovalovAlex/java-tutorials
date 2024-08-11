package tutorials.tutorials.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class MyCommand {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MousePress());
        receiver.runCommand();
    }
}
interface Command {
    void execute();
}
class MouseClick implements Command{
    @Override
    public void execute() {
        System.out.println("asdfff");
    }
}
class MousePress implements Command{
    @Override
    public void execute() {
        System.out.println("asd");
    }
}

class Receiver{

    List<Command> commands = new ArrayList<>();

    void addCommand(Command command){

        commands.add(command);
    }

    void runCommand(){
        for (Command command : commands) {
                command.execute();
        }
    }
}
