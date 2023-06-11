package gr.athtech.babyfeed.service;


import gr.athtech.babyfeed.model.Session;

import java.util.List;
import java.util.Optional;

public interface RecordService {

  Session saveRecord(Session record);

  Session readRecord(int sessionId);

  String deleteRecord(int sessionId);

  List<Session> listAll();
}
