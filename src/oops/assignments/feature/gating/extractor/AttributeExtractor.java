package oops.assignments.feature.gating.extractor;

import oops.assignments.feature.gating.keys.AttributeKey;
import oops.assignments.feature.gating.operands.Operand;

import java.util.Map;

public abstract class AttributeExtractor {

    Map<String, Object> attributes;

    public AttributeExtractor(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract Operand extract(AttributeKey attributeKey);
}
