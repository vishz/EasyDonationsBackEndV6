package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.Model.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorRequirementViewDto {
    @Id
    private String id;
    private String requirementDescription;
    private String quantity;
    private String requirementItem;
    private String estimatedCost;
    private String brand;
    private Hospital hospital;

}
