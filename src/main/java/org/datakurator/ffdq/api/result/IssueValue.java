package org.datakurator.ffdq.api.result;

import org.datakurator.ffdq.api.ResultValue;
import org.datakurator.ffdq.model.Entity;

public class IssueValue implements ResultValue {
    private final String value;

    private IssueValue(String value) {
        if (value.equalsIgnoreCase("PROBLEM") || value.equalsIgnoreCase("NOT_PROBLEM") || value.equalsIgnoreCase("POTENTIAL_PROBLEM")) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Invalid value " + value + " for a validation result. Must one of " +
                   "\"PROBLEM\", \"POTENTIAL_PROBLEM\" or \"NOT_PROBLEM\".");
        }
    }

    @Override
    public String getObject() {
        return value;
    }

    @Override
    public Entity getEntity() {
        Entity entity = new Entity();
        entity.setValue(value);

        return entity;
    }

    public static IssueValue PROBLEM = new IssueValue("PROBLEM");
    public static IssueValue NOT_PROBLEM = new IssueValue("NOT_PROBLEM");
    public static IssueValue POTENTIAL_PROBLEM = new IssueValue("POTENTIAL_PROBLEM");
    
    public String getLabel() { 
    	return value;
    }
    
}
