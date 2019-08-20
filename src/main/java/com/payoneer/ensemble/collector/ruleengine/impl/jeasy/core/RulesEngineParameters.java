package com.payoneer.ensemble.collector.ruleengine.impl.jeasy.core;

public class RulesEngineParameters {

    public static final int DEFAULT_RULE_PRIORITY_THRESHOLD = Integer.MAX_VALUE;
    
    /**
     * Parameter to skip next applicable rules when a rule is applied.
     */
    private boolean skipOnFirstAppliedRule;

    /**
     * Parameter to skip next applicable rules when a rule is non triggered
     */
    private boolean skipOnFirstNonTriggeredRule;

    /**
     * Parameter to skip next applicable rules when a rule has failed.
     */
    private boolean skipOnFirstFailedRule;

    /**
     * Parameter to skip next rules if priority exceeds a user defined threshold.
     */
    private int priorityThreshold;

    public RulesEngineParameters() {
        this.priorityThreshold = RulesEngineParameters.DEFAULT_RULE_PRIORITY_THRESHOLD;
    }

    public RulesEngineParameters(final boolean skipOnFirstAppliedRule, final boolean skipOnFirstFailedRule, final boolean skipOnFirstNonTriggeredRule, final int priorityThreshold) {
        this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
        this.skipOnFirstFailedRule = skipOnFirstFailedRule;
        this.skipOnFirstNonTriggeredRule = skipOnFirstNonTriggeredRule;
        this.priorityThreshold = priorityThreshold;
    }

    public int getPriorityThreshold() {
        return priorityThreshold;
    }

    public void setPriorityThreshold(final int priorityThreshold) {
        this.priorityThreshold = priorityThreshold;
    }

    public RulesEngineParameters priorityThreshold(final int priorityThreshold) {
        setPriorityThreshold(priorityThreshold);
        return this;
    }

    public boolean isSkipOnFirstAppliedRule() {
        return skipOnFirstAppliedRule;
    }

    public void setSkipOnFirstAppliedRule(final boolean skipOnFirstAppliedRule) {
        this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
    }

    public RulesEngineParameters skipOnFirstAppliedRule(final boolean skipOnFirstAppliedRule) {
        setSkipOnFirstAppliedRule(skipOnFirstAppliedRule);
        return this;
    }

    public boolean isSkipOnFirstNonTriggeredRule() {
        return skipOnFirstNonTriggeredRule;
    }

    public void setSkipOnFirstNonTriggeredRule(final boolean skipOnFirstNonTriggeredRule) {
        this.skipOnFirstNonTriggeredRule = skipOnFirstNonTriggeredRule;
    }

    public RulesEngineParameters skipOnFirstNonTriggeredRule(final boolean skipOnFirstNonTriggeredRule) {
        setSkipOnFirstNonTriggeredRule(skipOnFirstNonTriggeredRule);
        return this;
    }

    public boolean isSkipOnFirstFailedRule() {
        return skipOnFirstFailedRule;
    }

    public void setSkipOnFirstFailedRule(final boolean skipOnFirstFailedRule) {
        this.skipOnFirstFailedRule = skipOnFirstFailedRule;
    }

    public RulesEngineParameters skipOnFirstFailedRule(final boolean skipOnFirstFailedRule) {
        setSkipOnFirstFailedRule(skipOnFirstFailedRule);
        return this;
    }

    @Override
    public String toString() {
        return "Engine parameters { " +
                "skipOnFirstAppliedRule = " + skipOnFirstAppliedRule +
                ", skipOnFirstNonTriggeredRule = " + skipOnFirstNonTriggeredRule +
                ", skipOnFirstFailedRule = " + skipOnFirstFailedRule +
                ", priorityThreshold = " + priorityThreshold +
                " }";
    }
}
