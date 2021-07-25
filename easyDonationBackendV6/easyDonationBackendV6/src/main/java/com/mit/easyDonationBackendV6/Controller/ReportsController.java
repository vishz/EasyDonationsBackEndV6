package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/easyDonations/reports")
@CrossOrigin
@RequiredArgsConstructor
public class ReportsController {

    private final ReportService reportService;

    @GetMapping(value = "/Admin/donationsTime", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ReportXYDto>>> getDonationsTimeDetails() {
       List<ReportXYDto> reportXYDtoList = reportService.getDonationTimeDetails();
        return ResponseEntity.ok(new CommonResponse<>(true, reportXYDtoList));
    }

    @GetMapping(value = "/Admin/donationsRequestsTime", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ReportXYDto>>> getDonationsRequestsTimeDetails() {
        List<ReportXYDto> reportXYDtoList = reportService.getDonationRequestsTimeDetails();
        return ResponseEntity.ok(new CommonResponse<>(true, reportXYDtoList));
    }

    @GetMapping(value = "/Admin/BudgetsTime", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ReportXYDto>>> getBudgetsTimeDetails() {
        List<ReportXYDto> reportXYDtoList = reportService.getBudgetTimeDetails();
        return ResponseEntity.ok(new CommonResponse<>(true, reportXYDtoList));
    }

    @PostMapping(value = "/donor/donationsTime", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ReportXYDto>>> getDonationsTime(@RequestBody DonorUserNameDto donorUserNameDto) {
        List<ReportXYDto> reportXYDtoList = reportService.getTimeDonationsDetails(donorUserNameDto);
        return ResponseEntity.ok(new CommonResponse<>(true, reportXYDtoList));
    }

    @GetMapping(value = "/Vendor/BudgetsRequirements", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ReportXYDto>>> getBudgetsRequirementDetails() {
        List<ReportXYDto> reportXYDtoList = reportService.getRequirementsBudgetDetails();
        return ResponseEntity.ok(new CommonResponse<>(true, reportXYDtoList));
    }

    @PostMapping(value = "/hospital/requirements/donationAmounts", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ReportXYDto>>> getDonationAmountsForRequirements(@RequestBody HospitalUsernameDto hospitalUsernameDto) {
        List<ReportXYDto> reportXYDtoList = reportService.getRequirementsAmountDetails(hospitalUsernameDto);
        return ResponseEntity.ok(new CommonResponse<>(true, reportXYDtoList));
    }
}
