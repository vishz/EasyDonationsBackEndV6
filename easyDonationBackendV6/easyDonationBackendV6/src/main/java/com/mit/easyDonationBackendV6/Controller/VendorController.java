package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.CommonResponse;
import com.mit.easyDonationBackendV6.Dto.HospitalRequirementSubmittingDto;
import com.mit.easyDonationBackendV6.Dto.VendorBudgetDto;
import com.mit.easyDonationBackendV6.Dto.VendorStatisticsDto;
import com.mit.easyDonationBackendV6.Service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/easyDonations/vendor")
@CrossOrigin
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @PostMapping(value = "/submit/vendorBudget", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> submitVendorBudget(@RequestBody VendorBudgetDto vendorBudgetDto) {
        vendorService.submitBudgetDetails(vendorBudgetDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "you have successfully submitted the Budget Details"));
    }

    @PostMapping(value = "/statistics", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<VendorStatisticsDto>> getStatistics() {
        VendorStatisticsDto vendorStatisticsDto = vendorService.getStatistics();
        return ResponseEntity.ok(new CommonResponse<>(true, vendorStatisticsDto));
    }
}
