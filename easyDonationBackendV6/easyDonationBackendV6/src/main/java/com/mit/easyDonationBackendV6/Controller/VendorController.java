package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/statistics",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<VendorStatisticsDto>> getStatistics(@RequestBody VendorUserNameDto vendorUserNameDto) {
        VendorStatisticsDto vendorStatisticsDto = vendorService.getStatistics(vendorUserNameDto);
        return ResponseEntity.ok(new CommonResponse<>(true, vendorStatisticsDto));
    }

    @PostMapping(value = "/view/requirements", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<VendorViewRequirementsDto>>> viewRequirements() {
        List<VendorViewRequirementsDto> vendorViewRequirementsDtoList = vendorService.viewRequirements();
        return ResponseEntity.ok(new CommonResponse<>(true, vendorViewRequirementsDtoList));

    }
}
