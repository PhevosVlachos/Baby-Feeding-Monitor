package gr.athtech.babyfeed;

import gr.athtech.babyfeed.model.Session;
import gr.athtech.babyfeed.service.RecordService;
import gr.athtech.babyfeed.service.RecordServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
public class RecordResource {
RecordServiceImpl recordService = new RecordServiceImpl();


    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

//    @Path("/recorss")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Session getRecord() {
//        Session session = new Session();
//        session.setDuration(2);
//        session.setId(2);
//
//
//        return session;
//    }

    @Path("/record")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Session getRecor() {
        Session record = new Session();
        record.setDuration(2);
        record.setId(2);


        return recordService.saveRecord(record);
    }
}