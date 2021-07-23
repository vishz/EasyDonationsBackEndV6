package com.mit.easyDonationBackendV6.Controller;

import com.mit.easyDonationBackendV6.Dto.CommonResponse;
import com.mit.easyDonationBackendV6.Dto.LoginDto;
import com.mit.easyDonationBackendV6.Dto.RegistrationDto;
import com.mit.easyDonationBackendV6.Model.Admin;
import com.mit.easyDonationBackendV6.Repository.AdminRepository;
import com.mit.easyDonationBackendV6.Service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/easyDonations")
@CrossOrigin
@RequiredArgsConstructor
public class CommonController {
    private final AdminRepository adminRepository;
    private final CommonService commonService;

//    @PostMapping(value = "/signUp", consumes = APPLICATION_JSON_VALUE)
//    public String saveAdmin(@RequestBody Admin admin){
//        adminRepository.save(admin);
//        return "Added book with id: "+ admin.getId();
//    }

    @PostMapping(value = "/signIn", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> signIn(@RequestBody LoginDto loginDto) {
        commonService.signIn(loginDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "you have successfully logged in"));
    }

    @PostMapping(value = "/signUp", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> signUp(@RequestBody RegistrationDto registrationDto) {
        System.out.print(registrationDto);
        commonService.signUp(registrationDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "you have successfully signed up"));
    }

}
