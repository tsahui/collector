package com.collector.ruleengine.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rule implements Comparable<Rule> {

    private static String DEFAULT_NAME = "rule";
    private static String DEFAULT_DESCRIPTION = "description";
    private static int DEFAULT_PRIORITY = Integer.MAX_VALUE - 1;

    private String name;
    private String description;
    private int priority;
    private Condition condition = Condition.FALSE;
    private List<Action> actions = new ArrayList<>();



    public Rule(String name, String description, int priority, Condition condition, List<Action> actions) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.condition = condition;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Condition getCondition() {
        return condition;
    }

    public List<Action> getActions() {
        return actions;
    }

    public boolean evaluate(Facts facts) {
        return condition.evaluate(facts);
    }

    public void execute(Facts facts) throws Exception {
        for (Action action : actions) {
            action.execute(facts);
        }
    }

    public String getAction() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return priority == rule.priority &&
                Objects.equals(name, rule.name) &&
                Objects.equals(description, rule.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, priority);
    }

    @Override
    public int compareTo(final Rule rule) {
        if (getPriority() < rule.getPriority()) {
            return -1;
        } else if (getPriority() > rule.getPriority()) {
            return 1;
        } else {
            return getName().compareTo(rule.getName());
        }
    }

    @Override
    public String toString() {
        return "Rule{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }

    public class RuleBuilder {

        private String name = Rule.DEFAULT_NAME;
        private String description = Rule.DEFAULT_DESCRIPTION;
        private int priority = Rule.DEFAULT_PRIORITY;

        private Condition condition = Condition.FALSE;
        private List<Action> actions = new ArrayList<>();


        public RuleBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RuleBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RuleBuilder withPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public RuleBuilder when(Condition condition) {
            this.condition = condition;
            return this;
        }

        public RuleBuilder then(Action action) {
            this.actions.add(action);
            return this;
        }

        public Rule build() {
            return new Rule(name, description, priority, condition, actions);
        }
    }
}