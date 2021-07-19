package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.CommonResponse;
import com.mit.easyDonationBackendV6.Dto.DonateDto;
import com.mit.easyDonationBackendV6.Dto.HospitalRequirementSubmittingDto;
import com.mit.easyDonationBackendV6.Service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/easyDonations/donor")
@CrossOrigin
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @PostMapping(value = "/donate", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> donate(@RequestBody DonateDto donateDto) {
        donorService.donate(donateDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "You have Successfully Completed the Donation"));
    }
}
