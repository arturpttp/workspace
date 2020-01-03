package net.dev.art.starter;

public class StarterConsole extends Console {

    public void performCommand(String command) {
        command = command.toLowerCase();
        String [] args = new String[]{command};
        if (command.contains(" "))
            args = command.split(" ");

        if (args[0].equalsIgnoreCase("say")) {
            if (command.contains(" ")) {
                String message = command.replaceFirst("say ", "");
                sendMessage(message);
            }else {
                sendMessage("say <message>");
            }
        }else if (args[0].equalsIgnoreCase("stop"))
            System.exit(0);
        else
            sendMessage("Command not found");


    }

    public void test(Test t) {
        System.out.println("test");
    }

    public interface Test {
        public void run(System s);
    }

}
