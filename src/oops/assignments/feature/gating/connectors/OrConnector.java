package oops.assignments.feature.gating.connectors;

import oops.assignments.feature.gating.operands.Operand;

public class OrConnector extends Connector {

    public static final String operator = "OR";
    public static final Integer precedence = 2;

    public OrConnector() {
        super(operator, precedence);
    }

    @Override
    public Operand compute(Operand op1, Operand op2) {
        return new Operand<>(op1.compareTo(true) == 0 || op2.compareTo(true) == 0);
    }
}
