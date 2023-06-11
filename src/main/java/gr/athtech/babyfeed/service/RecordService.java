package gr.athtech.babyfeed.service;


import gr.athtech.babyfeed.model.Session;

public interface RecordService {

  Session saveRecord(Session record);

  Session readRecord(int id);

  boolean deleteRecord(int id);
}
