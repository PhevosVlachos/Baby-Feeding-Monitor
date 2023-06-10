package gr.athtech.babyfeed.repository;


import gr.athtech.babyfeed.model.Session;

public interface RecordRepository {

    void save(Session record);
}
