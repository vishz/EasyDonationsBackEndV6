package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.Model.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorViewRequirementsDto {
    private String id;
    private String requirementDescription;
    private String quantity;
    private String requirementItem;
    private String estimatedCost;
    private int adminApproval;
    private String brand;
    private Hospital hospital;

}
