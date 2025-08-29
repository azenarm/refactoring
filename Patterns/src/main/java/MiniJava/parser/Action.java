package MiniJava.parser;

public abstract class Action {

    public abstract String toString();
}

enum act {
    shift, reduce, accept
}
