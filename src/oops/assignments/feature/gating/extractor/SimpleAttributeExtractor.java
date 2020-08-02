package oops.assignments.feature.gating.extractor;

import oops.assignments.feature.gating.keys.AttributeKey;
import oops.assignments.feature.gating.operands.Operand;

import java.util.Map;

public class SimpleAttributeExtractor extends AttributeExtractor {

    public SimpleAttributeExtractor(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public Operand extract(AttributeKey attributeKey) {
        Map<String, Object> map = getAttributes();
        String key = attributeKey.get();
        while(key.contains(".")) {
            map = (Map<String, Object>) map.get(key.split(".")[0]);
            key = key.substring(key.indexOf('.') + 1);
        }
        return new Operand<>((Comparable) map.get(key));
    }
}
