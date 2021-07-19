package com.mit.easyDonationBackendV6.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorBudgetDto {
    private String requirementId;
    private String pricePerOneItem;
    private String Quantity;
    private String vendorUserName;
}
