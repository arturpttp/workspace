package net.dev.art.core;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
//            API.getClasses(Core.class.getPackage().toString().replace("package ", "")).forEach(c -> {
//                System.out.println(c.getSimpleName());
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
