package com.example.symu_api.STOCK.Dto;

import lombok.Data;

import java.util.List;

@Data
public class StockApprovalDto {
    private List<Integer> stockCode;
    private int userCode;
    private int nextStatusCode;
}