package MiniJava;

public class Main {
    public static void main(String[] args) {
        MiniJavaFacade compiler = new MiniJavaFacade();
        compiler.compileFile("src/main/resources/code");
    }
}
