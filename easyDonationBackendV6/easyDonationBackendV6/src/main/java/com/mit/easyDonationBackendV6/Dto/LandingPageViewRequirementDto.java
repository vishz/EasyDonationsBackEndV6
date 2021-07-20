package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.Model.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LandingPageViewRequirementDto {
    private String id;
    private String requirementDescription;
    private String quantity;
    private String requirementItem;
    private String estimatedCost;
    private String brand;
    private Hospital hospital;

    public LandingPageViewRequirementDto(String requirementDescription, String quantity, String requirementItem, String estimatedCost, String brand, Hospital hospital) {
        this.requirementDescription = requirementDescription;
        this.quantity = quantity;
        this.requirementItem = requirementItem;
        this.estimatedCost = estimatedCost;
        this.brand = brand;
        this.hospital = hospital;
    }
}
