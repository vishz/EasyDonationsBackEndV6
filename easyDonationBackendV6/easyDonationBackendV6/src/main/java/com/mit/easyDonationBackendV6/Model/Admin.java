package com.mit.easyDonationBackendV6.Model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Getter
@Setter
@ToString

@Document(collection = "admin")
public class Admin {

//    @Transient
//    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String id;
    private String name;
    private String userName;
    private String address;
    private String email;
    private String mobileNumber;
    private String password;

    public Admin(String name, String userName, String address, String email, String mobileNumber, String password) {
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }
}
