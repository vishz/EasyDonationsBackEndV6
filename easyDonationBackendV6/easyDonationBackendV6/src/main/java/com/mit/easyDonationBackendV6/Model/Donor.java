package com.mit.easyDonationBackendV6.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@ToString

@Document(collection = "donor")
public class Donor {
    @Id
    private String id;
    private String name;
    private String userName;
    private String address;
    private String email;
    private String mobileNumber;
    private String password;

    public Donor(String name, String userName, String address, String email, String mobileNumber, String password) {
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }
}
