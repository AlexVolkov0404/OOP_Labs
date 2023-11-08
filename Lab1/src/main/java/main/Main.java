package main;

import menu.ConsoleMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;



public class Main {
    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {

        logger.info("Info log message");

        //ConsoleMenu menu = new ConsoleMenu();
        //menu.run();
    }
}