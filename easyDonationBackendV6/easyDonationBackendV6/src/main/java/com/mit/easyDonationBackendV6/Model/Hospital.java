package com.mit.easyDonationBackendV6.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hospital")
public class Hospital {
    @Id
    private String id;
    private String name;
    private String userName;
    private String address;
    private String email;
    private String mobileNumber;
    private String password;
    private HospitalCategory hospitalCategory;

    public Hospital(String name, String userName, String address, String email, String mobileNumber, String password, HospitalCategory hospitalCategory) {
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.hospitalCategory = hospitalCategory;
    }
}
