package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/easyDonations/hospital")
@CrossOrigin
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @PostMapping(value = "/submit/requirement", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> submitRequirement(@RequestBody HospitalRequirementSubmittingDto hospitalRequirementSubmittingDto) {
        hospitalService.submitRequirement(hospitalRequirementSubmittingDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "you have successfully submitted the requirement"));
    }

    @PutMapping(value = "/update/requirement", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> updateRequirement(@RequestBody HospitalViewSubmissionsDto hospitalViewSubmissionsDto) {
        hospitalService.updateRequirementSubmission(hospitalViewSubmissionsDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "you have successfully updated the requirement"));
    }

    @PostMapping(value = "/delete/requirement", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> deleteRequirement(@RequestBody RequirementIdDto requirementIdDto) {
        hospitalService.deleteRequirement(requirementIdDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "you have successfully deleted the requirement"));
    }

    @PostMapping(value = "/dashboard/statistics", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<HospitalStatisticsDto>> getDashBoardStatistics(@RequestBody HospitalUsernameDto hospitalUsernameDto) {
        HospitalStatisticsDto hospitalStatisticsDto = hospitalService.getHospitalStatistics(hospitalUsernameDto);
        return ResponseEntity.ok(new CommonResponse<>(true, hospitalStatisticsDto));
    }

    @PostMapping(value = "/requirements/view", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ViewHospitalRequirementDto>>> viewRequirements(@RequestBody HospitalUsernameDto hospitalUsernameDto) {
        List<ViewHospitalRequirementDto> requirementDtoList = hospitalService.viewHospitalRequirements(hospitalUsernameDto);
        return ResponseEntity.ok(new CommonResponse<>(true, requirementDtoList));
    }
}
