package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.AccountDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountDetailRepository extends MongoRepository<AccountDetail,String> {
}
