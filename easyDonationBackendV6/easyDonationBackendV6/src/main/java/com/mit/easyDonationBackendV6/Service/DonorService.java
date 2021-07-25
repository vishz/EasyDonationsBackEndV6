package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.DonateDto;
import com.mit.easyDonationBackendV6.Dto.DonorUserNameDto;

public interface DonorService {

    void donate(DonateDto donateDto);
    int donationsCount(DonorUserNameDto donorUserNameDto);

}
