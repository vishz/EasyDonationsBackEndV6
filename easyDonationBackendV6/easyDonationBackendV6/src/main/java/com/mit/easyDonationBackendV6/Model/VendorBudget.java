package com.mit.easyDonationBackendV6.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "vendor_budget")
public class VendorBudget {
    @Id
    private String id;
    private String pricePerOneItem;
    private String Quantity;
    //0=pending
    private int adminApproval;
    private HospitalRequirement hospitalRequirement;
    private Vendor vendor;

    public VendorBudget(String pricePerOneItem, String quantity, int adminApproval, HospitalRequirement hospitalRequirement, Vendor vendor) {
        this.pricePerOneItem = pricePerOneItem;
        Quantity = quantity;
        this.adminApproval = adminApproval;
        this.hospitalRequirement = hospitalRequirement;
        this.vendor = vendor;
    }
}
