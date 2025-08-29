package MiniJava;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MiniJavaFacade {
    private final Parser parser;

    public MiniJavaFacade() {
        this.parser = new Parser();
    }

    public void compileFile(String filePath) {
        try {
            compileScanner(new Scanner(new File(filePath)));
        } catch (FileNotFoundException e) {
            ErrorHandler.printError(e.getMessage());
        }
    }

    private void compileScanner(Scanner scanner) {
        parser.startParse(scanner);
    }
}
