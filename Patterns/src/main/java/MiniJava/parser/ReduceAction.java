package MiniJava.parser;

public class ReduceAction extends Action {

    public int ruleNumber;

    public ReduceAction(int ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    @Override
    public String toString() {
        return "r" + ruleNumber;
    }
}
