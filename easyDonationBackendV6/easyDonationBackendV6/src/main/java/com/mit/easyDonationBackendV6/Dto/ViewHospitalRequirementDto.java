package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.Model.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewHospitalRequirementDto {
    private String id;
    private String requirementDescription;
    private String quantity;
    private String requirementItem;
    private String estimatedCost;
    private String brand;
    //0=pending 1=rejected 2=approved
    private int adminApproval;
    //0=pending 1=close
    private int donationStatus;
    private Hospital hospital;
}
