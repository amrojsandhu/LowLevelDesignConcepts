package oops.assignments.feature.gating.connectors;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.TokenCreator;

import javax.activation.UnsupportedDataTypeException;

public class ConnectorCreator extends TokenCreator {

    @Override
    public Token create(Comparable object) throws Exception {
        if (!(object instanceof String)) {
            throw new UnsupportedDataTypeException("Not supported.");
        }
        String op = (String) object;
        if (AndConnector.operator.equals(op))
            return new AndConnector();
        if (OrConnector.operator.equals(op))
            return new OrConnector();
        throw new UnsupportedDataTypeException(String.format("Unable to convert {%s} to a Connector.", op));
    }

}
