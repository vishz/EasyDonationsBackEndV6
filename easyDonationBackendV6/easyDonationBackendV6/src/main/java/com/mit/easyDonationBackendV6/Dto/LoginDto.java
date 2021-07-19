package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String role;
    private String userName;
    private String password;

}
