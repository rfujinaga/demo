package com.example.demo.domain.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PurchaseRequest {
    @JsonProperty("co_transaction_id")//キーの名前
    private String coTransactionId;

    @JsonProperty("user_id")//キーの名前
    private String userId;

    @JsonProperty("item_name")//キーの名前
    private String itemName;

    @JsonProperty("amount")//キーの名前
    private String amount;
}
