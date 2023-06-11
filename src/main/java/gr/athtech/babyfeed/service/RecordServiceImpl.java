package gr.athtech.babyfeed.service;


import gr.athtech.babyfeed.model.Session;
import gr.athtech.babyfeed.repository.RecordRepository;
import gr.athtech.babyfeed.repository.RecordRepositoryImpl;
import jakarta.inject.Inject;

import java.util.Optional;

public class RecordServiceImpl implements RecordService {

    private RecordRepositoryImpl recordRepository = new RecordRepositoryImpl() ;


    @Override
    public Session saveRecord(Session record) {
    Session session = new Session();
    session = record;

    recordRepository.save(session);

    return session;






    }

    @Override
    public Session readRecord(int id) {
        Optional<Session> record = recordRepository.findById(id);

        if (record.isPresent()) {
            Session ses = new Session();
            ses = record.get();
            return ses;
        } else {
            Session ses = new Session();
            ses.setId(-1);
            return ses;
        }
    }

    @Override
    public boolean deleteRecord(int id) {
        return false;
    }
}
