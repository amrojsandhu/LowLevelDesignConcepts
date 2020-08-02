package oops.assignments.feature.gating.evaluating;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.TokenCreator;
import oops.assignments.feature.gating.brackets.SpecialCharsCreator;
import oops.assignments.feature.gating.connectors.ConnectorCreator;
import oops.assignments.feature.gating.keys.AttributeKeyCreator;
import oops.assignments.feature.gating.operands.OperandCreator;
import oops.assignments.feature.gating.operators.OperatorCreator;
import oops.assignments.feature.gating.utils.TokenizerUtil;

import javax.activation.UnsupportedDataTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionTokenizer {

    private Token[] tokens;

    public ConditionTokenizer(String condition) throws Exception {
        String[] parts = TokenizerUtil.tokenize(condition);
        tokens = createTokens(parts);
    }

    public Token[] getTokens() {
        return tokens;
    }

    private Token[] createTokens(String[] parts) throws Exception {
        List<Token> tokens = new ArrayList<>();
        for (String part : parts) {
            TokenCreator tokenCreator;
            part = part.trim();
            if (part.matches("(AND)|(OR)")) {
                tokenCreator = new ConnectorCreator();
            } else if (part.matches("(>)|(==)")) {
                tokenCreator = new OperatorCreator();
            } else if (part.matches("(true)|(false)|(\".*\")|([0-9]*)")) {
                tokenCreator = new OperandCreator();
            } else if (part.matches("[a-zA-Z0-9_.]*")) {
                tokenCreator = new AttributeKeyCreator();
            } else if (part.matches("(\\()|(\\))")) {
                tokenCreator = new SpecialCharsCreator();
            } else {
                throw new UnsupportedDataTypeException(String.format("Substring: {%s} is not supported", part));
            }
            tokens.add(tokenCreator.createToken(part));
        }

        System.out.println(String.format("Tokens: %s", Arrays.toString(tokens.toArray())));
        return tokens.toArray(new Token[0]);
    }
}
