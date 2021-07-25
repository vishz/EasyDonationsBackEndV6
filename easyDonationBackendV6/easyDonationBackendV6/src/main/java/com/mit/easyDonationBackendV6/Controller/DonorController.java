package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Model.FeedBack;
import com.mit.easyDonationBackendV6.Service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    @PostMapping(value = "/count/donations", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<Integer>> donate(@RequestBody DonorUserNameDto donorUserNameDto) {
        int donationCount = donorService.donationsCount(donorUserNameDto);
        return ResponseEntity.ok(new CommonResponse<>(true, donationCount));
    }

    @PostMapping(value = "/view/donations", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<DonationDto>>> viewDonations(@RequestBody DonorUserNameDto donorUserNameDto) {
        List<DonationDto> donationDtoList = donorService.getRelevantDonationDetails(donorUserNameDto);
        return ResponseEntity.ok(new CommonResponse<>(true, donationDtoList));
    }

    @PostMapping(value = "/donation/vendorDetails", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<BudgetVendorDetailsDto>>> getVendorDetails(@RequestBody RequirementIdDto requirementIdDto) {
        List<BudgetVendorDetailsDto> budgetVendorDetailsDtoList = donorService.getBudgetsRelatedToRequirements(requirementIdDto);
        return ResponseEntity.ok(new CommonResponse<>(true, budgetVendorDetailsDtoList));
    }

    @PostMapping(value = "/feedBack", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> giveFeedBack(@RequestBody FeedBackDto feedBack) {
         donorService.giveFeedBack(feedBack);
        return ResponseEntity.ok(new CommonResponse<>(true, "Thank you for giving Feed Backs"));
    }



}
