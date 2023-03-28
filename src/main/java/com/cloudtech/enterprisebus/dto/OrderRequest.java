package com.cloudtech.enterprisebus.dto;
import lombok.Data;

@Data
public class OrderRequest {
    private String productName;
    private Long postUserId;
    private Long purchaseUserId;
}
