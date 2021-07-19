package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private String name;
    private String userName;
    private String address;
    private String email;
    private String mobileNumber;
    private String password;
    private String role;
    private String categoryName;


}
