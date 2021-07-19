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

    private String pricePerOneItem;
    private String Quantity;
    private int adminApproval;
    private HospitalRequirement hospitalRequirement;
    private Vendor vendor;

}
