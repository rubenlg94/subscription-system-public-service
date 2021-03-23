package com.rubenlg94.publicservice.constants;

public final class Endpoints {

    public static class SubscriptionService {

        private SubscriptionService() {
        }

        public static final String CREATE_SUBSCRIPTION = "/subscriptions";
        public static final String GET_SUBSCRIPTION_DETAILS = "/subscriptions/%s/details";
        public static final String CANCEL_SUBSCRIPTION_BY_ID = "/subscriptions/%s/cancel";
        public static final String CANCEL_SUBSCRIPTION = "/subscriptions/cancel";
        public static final String GET_ALL_SUBSCRIPTIONS = "/subscriptions/all";
    }

}
