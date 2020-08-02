package oops.assignments.feature.gating.brackets;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.TokenCreator;

import javax.activation.UnsupportedDataTypeException;

public class SpecialCharsCreator extends TokenCreator {

    @Override
    public Token create(Comparable object) throws Exception {
        if (!(object instanceof String)) {
            throw new UnsupportedDataTypeException("Not supported.");
        }
        Character op = ((String) object).charAt(0);
        if (StartBracket.connector.equals(op))
            return new StartBracket();
        if (EndBracket.connector.equals(op))
            return new EndBracket();
        throw new UnsupportedDataTypeException(String.format("Unable to convert {0} to a Special Char.", op));
    }
}
