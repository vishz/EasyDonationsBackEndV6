package com.mit.easyDonationBackendV6.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorStatisticsDto {
    private int noOfBudgetSubmissions;
    private int noOfPurchases;
}
