package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.Model.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRequirementSubmittingDto {

    private String requirementDescription;
    private String requirementItem;
    private String quantity;
    private String estimatedCost;
    private String brand;
    //0=pending 1=rejected 2=approved
    private int adminApproval;
    //0=pending 1=close
    private int donationStatus;
    private String hospitalUserName;
}
