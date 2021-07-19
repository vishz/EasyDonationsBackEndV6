package com.mit.easyDonationBackendV6.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vendor")
public class Vendor {
    @Id
    private String id;
    private String name;
    private String userName;
    private String address;
    private String email;
    private String mobileNumber;
    private String password;
    private VendorCategory vendorCategory;

    public Vendor(String name, String userName, String address, String email, String mobileNumber, String password, VendorCategory vendorCategory) {
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.vendorCategory = vendorCategory;
    }
}
