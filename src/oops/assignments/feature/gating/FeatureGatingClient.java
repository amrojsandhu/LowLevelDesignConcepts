package oops.assignments.feature.gating;

import oops.assignments.feature.gating.evaluating.ConditionEvaluator;

import java.util.HashMap;
import java.util.Map;

public class FeatureGatingClient {

    public static void main(String[] args) {
        String condition = "( age > 25 AND gender == \"Male\" ) OR ( past_order_amount > 10000 )";
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 27);
        attributes.put("gender", "Male");
        attributes.put("past_order_amount", 100);

        try {
            ConditionEvaluator conditionEvaluator = new ConditionEvaluator(attributes, condition);
            Token<Boolean> response = conditionEvaluator.evaluate();
            System.out.println(String.format("Response for the given condition: %s", response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
