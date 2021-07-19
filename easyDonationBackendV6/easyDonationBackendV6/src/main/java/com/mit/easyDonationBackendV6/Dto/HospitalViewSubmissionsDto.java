package com.mit.easyDonationBackendV6.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalViewSubmissionsDto {
    private String id;
    private String requirementDescription;
    private String requirementItem;
    private String quantity;
    private String estimatedCost;
    private String brand;
    //0=pending 1=rejected 2=approved
    private int adminApproval;
    //0=pending 1=close
    private int donationStatus;
}
