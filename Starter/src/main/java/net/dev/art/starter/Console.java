package net.dev.art.starter;

import java.util.Scanner;

public abstract class Console {

    public Console() {
        init();
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            performCommand(line);
        }
    }

    public void sendMessage(String message) {
        System.out.println(message);
    }

    public abstract void performCommand(String command);

}
