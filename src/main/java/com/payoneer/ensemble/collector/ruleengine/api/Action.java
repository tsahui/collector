package com.payoneer.ensemble.collector.ruleengine.api;


public interface Action {

    void execute(Facts facts) throws Exception;
}