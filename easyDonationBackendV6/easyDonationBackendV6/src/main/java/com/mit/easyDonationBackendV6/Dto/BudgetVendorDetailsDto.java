package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.Model.Vendor;
import com.mit.easyDonationBackendV6.Model.VendorBudget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetVendorDetailsDto {
    private VendorBudget vendorBudget;
}
