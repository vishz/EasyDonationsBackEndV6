package com.mit.easyDonationBackendV6.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "AccountDetail")
public class AccountDetail {
    @Id
    private String id;
    private String bankName;
    private String cardName;
    private String expireDate;
    private String cvvNumber;
    private Donor donor;

    public AccountDetail(String bankName, String cardName, String expireDate, String cvvNumber, Donor donor) {
        this.bankName = bankName;
        this.cardName = cardName;
        this.expireDate = expireDate;
        this.cvvNumber = cvvNumber;
        this.donor = donor;
    }
}
