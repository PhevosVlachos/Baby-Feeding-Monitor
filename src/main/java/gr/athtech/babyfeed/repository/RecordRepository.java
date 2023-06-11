package gr.athtech.babyfeed.repository;


import gr.athtech.babyfeed.model.Session;

import java.util.List;
import java.util.Optional;

public interface RecordRepository {

    void save(Session record);

    Optional<Session> findById(int id);

    Optional<List<Session>> listAll();

    Optional<Session> update(int sessionId, Session record);

    boolean delete(int sessionId);
}
