package gr.athtech.babyfeed.service;


import gr.athtech.babyfeed.model.Session;
import gr.athtech.babyfeed.repository.RecordRepository;
import jakarta.inject.Inject;

public class RecordServiceImpl implements RecordService {
    @Inject
    private RecordRepository recordRepository ;


    @Override
    public Session saveRecord(Session record) {
    Session session = new Session();
    session = record;

    recordRepository.save(session);

    return session;




    }
}
