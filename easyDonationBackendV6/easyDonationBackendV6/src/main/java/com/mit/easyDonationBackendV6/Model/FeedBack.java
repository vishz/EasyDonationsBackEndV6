package com.mit.easyDonationBackendV6.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "feedback")
public class FeedBack {
    @Id
    private String id;
    private String content;
    private Donor donor;

    public FeedBack(String content, Donor donor) {
        this.content = content;
        this.donor = donor;
    }
}
