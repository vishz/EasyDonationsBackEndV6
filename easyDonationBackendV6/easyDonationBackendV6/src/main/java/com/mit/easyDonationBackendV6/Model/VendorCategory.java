package com.mit.easyDonationBackendV6.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "vendor_category")
public class VendorCategory {
    @Id
    private String id;
    private String categoryName;
}
