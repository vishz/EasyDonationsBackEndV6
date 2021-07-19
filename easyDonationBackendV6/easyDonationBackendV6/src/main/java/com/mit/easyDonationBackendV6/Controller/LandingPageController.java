package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.AdminApprovalBudgetDto;
import com.mit.easyDonationBackendV6.Dto.CommonResponse;
import com.mit.easyDonationBackendV6.Dto.LandingPageStatisticsDto;
import com.mit.easyDonationBackendV6.Dto.LandingPageViewRequirementDto;
import com.mit.easyDonationBackendV6.Service.LandingPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/easyDonations/landingPage")
@CrossOrigin
@RequiredArgsConstructor
public class LandingPageController {
 private final LandingPageService landingPageService;

    @PostMapping(value = "/statistics", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<LandingPageStatisticsDto>> getLandingPageStatistics() {
        LandingPageStatisticsDto landingPageStatisticsDto =landingPageService.getLandingPageStatistics();
        return ResponseEntity.ok(new CommonResponse<>(true, landingPageStatisticsDto));
    }

    @PostMapping(value = "/viewOpenRequirements", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<LandingPageViewRequirementDto>>> getLandingPageOpenRequirements() {
        List<LandingPageViewRequirementDto> landingPageViewRequirementDtoList = landingPageService.getAllRequirements();
        return ResponseEntity.ok(new CommonResponse<>(true, landingPageViewRequirementDtoList));
    }

    @PostMapping(value = "/viewCloseRequirements", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<LandingPageViewRequirementDto>>> getLandingPageCloseRequirements() {
        List<LandingPageViewRequirementDto> landingPageViewRequirementDtoList = landingPageService.getAllRequirements();
        return ResponseEntity.ok(new CommonResponse<>(true, landingPageViewRequirementDtoList));
    }
}
