package com.cloudtech.enterprisebus.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private Long userId;
    private Double price;
    private String description = "";
}

