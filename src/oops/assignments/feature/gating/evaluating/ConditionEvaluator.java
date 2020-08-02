package oops.assignments.feature.gating.evaluating;

import oops.assignments.feature.gating.Token;
import oops.assignments.feature.gating.specialchars.EndBracket;
import oops.assignments.feature.gating.specialchars.StartBracket;
import oops.assignments.feature.gating.connectors.Connector;
import oops.assignments.feature.gating.extractor.AttributeExtractor;
import oops.assignments.feature.gating.extractor.SimpleAttributeExtractor;
import oops.assignments.feature.gating.keys.AttributeKey;
import oops.assignments.feature.gating.operands.Operand;
import oops.assignments.feature.gating.operators.*;

import java.util.*;

public class ConditionEvaluator {

    AttributeExtractor attributeExtractor;
    Token[] tokens;

    public ConditionEvaluator(Map<String, Object> attributes, String condition) throws Exception {
        attributeExtractor = new SimpleAttributeExtractor(attributes);
        ConditionTokenizer conditionTokenizer = new ConditionTokenizer(condition);
        tokens = conditionTokenizer.getTokens();
    }

    /**
     * This function is similar to Expression Evaluator.
     *
     * @return true if the expression matches the conditions.
     * @throws Exception
     */
    public Token evaluate() {
        tokens = replaceAllOperators();

        Stack<Operand> values = new Stack<>();
        Stack<Token> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] instanceof Operand) {
                values.push((Operand) tokens[i]);
            } else if (tokens[i] instanceof StartBracket) {
                if (tokens[i + 2] instanceof EndBracket) {
                    values.push((Operand) tokens[i + 1]);
                    i = i + 2;
                } else {
                    ops.push(tokens[i]);
                }
            } else if (tokens[i] instanceof EndBracket) {
                while (!(ops.peek() instanceof StartBracket)) {
                    Connector connector = (Connector) ops.pop();
                    values.push(connector.compute(values.pop(), values.pop()));
                }
                ops.pop();
            } else if (tokens[i] instanceof Connector) {
                while (!ops.empty() &&
                        !(ops.peek() instanceof StartBracket) &&
                        ((Connector) tokens[i]).getPrecedence() <= ((Connector) ops.peek()).getPrecedence()) {
                    Connector connector = (Connector) ops.pop();
                    values.push(connector.compute(values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) {
            Connector connector = (Connector) ops.pop();
            values.push(connector.compute(values.pop(), values.pop()));
        }
        return values.pop();
    }

    private Token[] replaceAllOperators() {
        List<Token> result = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] instanceof AttributeKey) {
                tokens[i] = attributeExtractor.extract((AttributeKey) tokens[i]);
            }
        }
        for (int i = 0; i < tokens.length; i++) {
            if (!(tokens[i] instanceof Operand || tokens[i] instanceof Operator)) {
                result.add(tokens[i]);
            } else if (tokens[i] instanceof Operator) {
                result.add(((Operator) tokens[i]).compare((Operand) tokens[i - 1], (Operand) tokens[i + 1]));
                i++;
            }
        }
        return result.toArray(new Token[0]);
    }

}
