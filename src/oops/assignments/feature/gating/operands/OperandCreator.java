package oops.assignments.feature.gating.operands;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.TokenCreator;

import javax.activation.UnsupportedDataTypeException;

public class OperandCreator extends TokenCreator {

    @Override
    public Token create(Comparable object) throws Exception {
        if (!(object instanceof String)) {
            throw new UnsupportedDataTypeException("Operand Type not supported.");
        }
        String str = (String) object;
        if (str.matches("(true)|(false)")) {
            Boolean bool = (str == "true");
            return new Operand<>(bool);
        }
        if (str.matches("[0-9]*")) {
            return new Operand<>(Integer.parseInt(str));
        }
        str = str.replaceAll("\"", "");
        return new Operand<>(str);
    }
}
