package com.yang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FlowRuleController {

    public static void initFlowQpsRule() {
        List<FlowRule> ruleList = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("hello");
        // Set max qps to 1
        flowRule.setCount(1);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setLimitApp("default");
        ruleList.add(flowRule);
        FlowRuleManager.loadRules(ruleList);
    }

    @GetMapping("/hello/{name}")
    @SentinelResource(value = "hello", blockHandler = "helloBlockHandler")
    public String hello(@PathVariable("name") String name) {
        return String.format("Hello %s", name);
    }

    public static String helloBlockHandler(String name, BlockException blockException) {
        System.out.println(name + "被限流了");
        return name + "被限流了";
    }
}
