//package com.mit.easyDonationBackendV6.Service.ServiceImpl;
//
//import com.mit.easyDonationBackendV6.Service.SequenceGeneratorService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Objects;
//
//import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//
//@Log4j2
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
//@RequiredArgsConstructor
//@Service
//public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {
//    @Override
//    public Long generateSequence(String seqName) {
//        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
//                new Update().inc("seq",1), options().returnNew(true).upsert(true),
//                DatabaseSequence.class);
//        return !Objects.isNull(counter) ? counter.getSeq() : 1;
//    }
//}
