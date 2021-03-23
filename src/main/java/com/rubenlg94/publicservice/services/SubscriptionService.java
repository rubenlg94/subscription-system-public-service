package com.rubenlg94.publicservice.services;

import com.rubenlg94.publicservice.models.SubscriptionModel;

import java.util.List;

public interface SubscriptionService {

    Long createSubscription(SubscriptionModel subscriptionModel) throws Exception;

    SubscriptionModel getDetailsOfSubscription(Long subscriptionId);

    Long cancelSubscription(Long subscriptionId);

    Long cancelSubscription(String email, Long campaignId);

    List<SubscriptionModel> getAllSubscriptions();
}
