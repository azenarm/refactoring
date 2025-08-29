package MiniJava.parser;

public class ShiftAction extends Action {

    public int state;

    public ShiftAction(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "s" + state;
    }
}
