package com.example.symu_api.STOCK.Dto;

import lombok.Data;

@Data
public class StockPostSaleDto {
    private int stockCode;
    private int userCode;
    private int nextStatusCode;
    private String tradingName;
    private String customerNationalId;
    private String customerName;
    private String customerPhoneNumber;
}