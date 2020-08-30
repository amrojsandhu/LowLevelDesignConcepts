package oops.assignments.feature.gating.keys;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.TokenCreator;

import javax.activation.UnsupportedDataTypeException;

public class AttributeKeyCreator extends TokenCreator {

    @Override
    public Token create(Comparable object) throws Exception {
        if (!(object instanceof String)) {
            throw new UnsupportedDataTypeException("Not supported.");
        }
        return new AttributeKey((String) object);
    }
}
