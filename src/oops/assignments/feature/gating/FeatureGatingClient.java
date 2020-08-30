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
            System.out.println(String.format("Condition: %s", condition));
            ConditionEvaluator conditionEvaluator = new ConditionEvaluator();
            Token<Boolean> response = conditionEvaluator.evaluate(attributes, condition);
            System.out.println(String.format("Response for the given condition: %s", response));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String condition2 = "age > 25 AND ( gender == \"Female\" OR order.total_amount > 1000 )";
        Map<String, Object> attributes2 = new HashMap<>();
        attributes2.put("age", 28);
        attributes2.put("gender", "Female");
        Map<String, Object> orders = new HashMap<>();
        orders.put("total_amount", 900);
        attributes2.put("order", orders);

        try {
            System.out.println(String.format("\nCondition: %s", condition2));
            ConditionEvaluator conditionEvaluator = new ConditionEvaluator();
            Token<Boolean> response = conditionEvaluator.evaluate(attributes2, condition2);
            System.out.println(String.format("Response for the given condition: %s", response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
