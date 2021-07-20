package com.mit.easyDonationBackendV6.Dto;


import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import com.mit.easyDonationBackendV6.Model.Vendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDetailsDto {
    private String id;
    private String pricePerOneItem;
    private String Quantity;
    private int adminApproval;
    private HospitalRequirement hospitalRequirement;
    private Vendor vendor;

    public BudgetDetailsDto(String pricePerOneItem, String quantity, int adminApproval, HospitalRequirement hospitalRequirement, Vendor vendor) {
        this.pricePerOneItem = pricePerOneItem;
        Quantity = quantity;
        this.adminApproval = adminApproval;
        this.hospitalRequirement = hospitalRequirement;
        this.vendor = vendor;
    }
}
