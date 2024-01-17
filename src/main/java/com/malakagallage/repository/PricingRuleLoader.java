package com.malakagallage.repository;

import com.malakagallage.model.PricingRule;

import java.util.List;

public interface PricingRuleLoader {

    List<PricingRule> loadPricingRules();
}
