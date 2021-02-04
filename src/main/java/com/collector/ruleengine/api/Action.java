package com.collector.ruleengine.api;


public interface Action {

    void execute(Facts facts) throws Exception;
}