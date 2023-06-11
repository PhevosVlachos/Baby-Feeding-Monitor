package gr.athtech.babyfeed;

import gr.athtech.babyfeed.model.Session;
import gr.athtech.babyfeed.service.RecordService;
import gr.athtech.babyfeed.service.RecordServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Path("/session")
public class RecordResource {
RecordServiceImpl recordService = new RecordServiceImpl();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Session> listAll() {
        return recordService.listAll();
    }

    @Path("/create")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Session createRecord() {
        Session record = new Session();
        record.setDuration(7);
        return recordService.saveRecord(record);
    }

    @Path("/{sessionId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Session getSession(@PathParam("sessionId") int sessionId) {
        return recordService.readRecord(sessionId);
    }





//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/DB_Write")
//    public String save(){
//        Session record = new Session();
//        record.setDuration(3);
//        record.setId(3);
//
//
//    return recordService.saveRecord(record);
//    }

}