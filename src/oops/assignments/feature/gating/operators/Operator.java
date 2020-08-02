package oops.assignments.feature.gating.operators;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.operands.Operand;

public abstract class Operator extends Token<String> {

    private int precedence;

    public Operator(String token, int precedence) {
        super(token);
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }

    public abstract Operand compare(Operand op1, Operand op2);
}
