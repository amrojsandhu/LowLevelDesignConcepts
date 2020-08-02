package oops.assignments.feature.gating.operators;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.TokenCreator;

import javax.activation.UnsupportedDataTypeException;

public class OperatorCreator extends TokenCreator {

    @Override
    public Token create(Comparable object) throws Exception {
        if (!(object instanceof String)) {
            throw new UnsupportedDataTypeException("Not supported.");
        }
        String op = (String) object;
        if (GreaterThanOperator.operator.equals(op))
            return new GreaterThanOperator();
        if (EqualsOperator.operator.equals(op))
            return new EqualsOperator();
        throw new UnsupportedDataTypeException(String.format("Unable to convert {%s} to a Operator.", op));
    }

}
