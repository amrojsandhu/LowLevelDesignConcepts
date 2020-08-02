package oops.assignments.feature.gating.connectors;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.operands.Operand;

public abstract class Connector extends Token<String> {

    private int precedence;

    public Connector(String token, int precedence) {
        super(token);
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }

    public abstract Operand compute(Operand op1, Operand op2);
}
