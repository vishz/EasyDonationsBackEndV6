package com.mit.easyDonationBackendV6.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "hospital_requirement")
public class HospitalRequirement {
    @Id
    private String id;
    private String requirementDescription;
    private String quantity;
    private String requirementItem;
    private String estimatedCost;
    private String brand;
    //1= active 0= delete
    private int requirementStatus;
    //0=pending 1=rejected 2=approved
    private int adminApproval;
    //0=pending 1=close
    private int donationStatus;
    private Hospital hospital;

    public HospitalRequirement(String requirementDescription, String quantity, String requirementItem, String estimatedCost, String brand, int requirementStatus, int adminApproval, int donationStatus, Hospital hospital) {
        this.requirementDescription = requirementDescription;
        this.quantity = quantity;
        this.requirementItem = requirementItem;
        this.estimatedCost = estimatedCost;
        this.brand = brand;
        this.requirementStatus = requirementStatus;
        this.adminApproval = adminApproval;
        this.donationStatus = donationStatus;
        this.hospital = hospital;
    }
}
