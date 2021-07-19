package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.LoginDto;
import com.mit.easyDonationBackendV6.Dto.RegistrationDto;

public interface CommonService {
    void signIn(LoginDto loginDto);
    void signUp(RegistrationDto registrationDto);
}
