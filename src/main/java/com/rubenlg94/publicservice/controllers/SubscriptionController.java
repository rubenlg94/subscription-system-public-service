package com.rubenlg94.publicservice.controllers;

import com.rubenlg94.publicservice.models.SubscriptionModel;
import com.rubenlg94.publicservice.services.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<?> createSubscription(@RequestBody SubscriptionModel subscriptionModel) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.createSubscription(subscriptionModel));
    }

    @GetMapping("/{subscriptionId}")
    public ResponseEntity<?> getDetailsOfSubscription(@PathVariable Long subscriptionId) {
        return ResponseEntity.ok(subscriptionService.getDetailsOfSubscription(subscriptionId));
    }

    @PutMapping("/{subscriptionId}/cancel")
    public ResponseEntity<?> cancelSubscription(@PathVariable Long subscriptionId) {
        return ResponseEntity.ok(subscriptionService.cancelSubscription(subscriptionId));
    }

    @PutMapping("/cancel")
    public ResponseEntity<?> cancelSubscription(@RequestParam String email,
                                                @RequestParam Long campaignId) {
        return ResponseEntity.ok(subscriptionService.cancelSubscription(email, campaignId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }

}
