package oops.assignments.feature.gating;

import javax.activation.UnsupportedDataTypeException;

public abstract class TokenCreator {

    public Token createToken(Object obj) throws Exception {
        if (!(obj instanceof Comparable<?>)) {
            throw new UnsupportedDataTypeException("Not supported.");
        }
        return create((Comparable) obj);
    }

    public abstract Token create(Comparable object) throws Exception;
}
