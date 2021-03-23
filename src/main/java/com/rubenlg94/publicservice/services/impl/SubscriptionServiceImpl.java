package com.rubenlg94.publicservice.services.impl;

import com.rubenlg94.publicservice.apifactory.components.APIFactory;
import com.rubenlg94.publicservice.constants.Apis;
import com.rubenlg94.publicservice.constants.Endpoints;
import com.rubenlg94.publicservice.models.SubscriptionModel;
import com.rubenlg94.publicservice.services.SubscriptionService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Override
    public Long createSubscription(SubscriptionModel subscriptionModel) throws Exception {
        validateSubscription(subscriptionModel);
        return APIFactory.fromApi(Apis.SUBSCRIPTION_SERVICE.getName()).post(Endpoints.SubscriptionService.CREATE_SUBSCRIPTION,
                subscriptionModel,
                Long.class).getBody();
    }

    @Override
    public SubscriptionModel getDetailsOfSubscription(Long subscriptionId) {
        return APIFactory.fromApi(Apis.SUBSCRIPTION_SERVICE.getName()).get(String.format(Endpoints.SubscriptionService.GET_SUBSCRIPTION_DETAILS, subscriptionId),
                new HashMap<>(),
                SubscriptionModel.class);
    }

    @Override
    public Long cancelSubscription(Long subscriptionId) {
        return APIFactory.fromApi(Apis.SUBSCRIPTION_SERVICE.getName()).put(String.format(Endpoints.SubscriptionService.CANCEL_SUBSCRIPTION_BY_ID, subscriptionId),
                null,
                Long.class).getBody();
    }

    @Override
    public Long cancelSubscription(String email, Long campaignId) {
        HashMap<String, List<String>> params = new HashMap<>();
        params.put("email", Collections.singletonList(email));
        params.put("campaignId", Collections.singletonList(String.valueOf(campaignId)));
        return APIFactory.fromApi(Apis.SUBSCRIPTION_SERVICE.getName()).put(Endpoints.SubscriptionService.CANCEL_SUBSCRIPTION,
                params,
                null,
                new ParameterizedTypeReference<Long>() {
                });
    }

    @Override
    public List<SubscriptionModel> getAllSubscriptions() {
        return APIFactory.fromApi(Apis.SUBSCRIPTION_SERVICE.getName()).get(Endpoints.SubscriptionService.GET_ALL_SUBSCRIPTIONS,
                new HashMap<>(),
                new ParameterizedTypeReference<List<SubscriptionModel>>() {
                });
    }

    private void validateSubscription(SubscriptionModel subscriptionModel) throws Exception {
        if (subscriptionModel.getEmail() == null || subscriptionModel.getEmail().isEmpty()
                || subscriptionModel.getConsent() == null
                || subscriptionModel.getCampaignId() == null || subscriptionModel.getCampaignId() < 1
                || subscriptionModel.getBirthDate() == null) {
            throw new Exception("Some required fields are null");
        }
    }
}
