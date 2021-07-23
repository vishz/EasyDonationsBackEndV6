package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Repository.AdminRepository;
import com.mit.easyDonationBackendV6.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping(value="/api/easyDonations/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;


    @PostMapping(value = "/requirement/approve", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> approveRequirement(@RequestBody RequirementIdDto requirementIdDto) {
        adminService.acceptRequirement(requirementIdDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "Requirement is approved"));
    }


    @PostMapping(value = "/requirement/reject", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> rejectRequirement(@RequestBody RequirementIdDto requirementIdDto) {
        adminService.rejectRequirement(requirementIdDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "Requirement is rejected"));
    }


    @PostMapping(value = "/budget/approve", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> approveBudget(@RequestBody AdminApprovalBudgetDto adminApprovalBudgetDto) {
        adminService.approveBudget(adminApprovalBudgetDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "Budget is approved"));
    }


    @PostMapping(value = "/budget/reject", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> rejectBudget(@RequestBody AdminApprovalBudgetDto adminApprovalBudgetDto) {
        adminService.rejectBudget(adminApprovalBudgetDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "Budget is rejected"));
    }


    @PostMapping(value = "/pendingRequirements", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<LandingPageViewRequirementDto>>> getPendingRequirements() {
        List<LandingPageViewRequirementDto> landingPageViewRequirementDtoList = adminService.getPendingRequirements();
        return ResponseEntity.ok(new CommonResponse<>(true, landingPageViewRequirementDtoList));
    }


    @PostMapping(value = "/view/allDonations", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<DonationDto>>> viewAllDonations() {
        List<DonationDto> donationDtoList = adminService.viewAllDonations();
        return ResponseEntity.ok(new CommonResponse<>(true, donationDtoList));
    }


    @PostMapping(value = "/view/allBudgetDetails", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<BudgetDetailsDto>>> viewAllBudgetDetails() {
        List<BudgetDetailsDto> budgetDetailsDtoList = adminService.viewAllBudgetDetails();
        return ResponseEntity.ok(new CommonResponse<>(true, budgetDetailsDtoList));
    }


    @PostMapping(value = "/view/pendingBudgetDetails", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<BudgetDetailsDto>>> viewPendingBudgetDetails() {
        List<BudgetDetailsDto> budgetDetailsDtoList = adminService.viewPendingBudgetDetails();
        return ResponseEntity.ok(new CommonResponse<>(true, budgetDetailsDtoList));
    }
}
