package oops.assignments.feature.gating.operators;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.operands.Operand;

public class EqualsOperator extends Operator {

    public static final String operator = "==";
    public static final Integer precedence = 0;

    public EqualsOperator() {
        super(operator, precedence);
    }

    @Override
    public Operand compare(Operand op1, Operand op2) {
        return new Operand<>(op1.compareTo(op2) == 0);
    }
}
