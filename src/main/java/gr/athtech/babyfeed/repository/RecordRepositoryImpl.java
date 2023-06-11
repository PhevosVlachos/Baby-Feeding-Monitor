package gr.athtech.babyfeed.repository;


import gr.athtech.babyfeed.model.Session;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.in;

public class RecordRepositoryImpl implements RecordRepository {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB";
    private static final String USER = "root";
    private static final String PASS = "1234";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static Connection conn;

    //Constructor
    public RecordRepositoryImpl() {
        // Load the JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            /*return "Where is your PostgreSQL JDBC Driver? " + "Include in your
            library path!";*/
        }

        // Open a connection
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            //return "Connection Failed! Check output console";
        }
    }


    @Override
    public void save(Session record) {

        String sqlCommand = "insert into Session (duration) values(?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, record.getDuration());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Session> findById(int id) {
        String sqlCommand = "select * from Session where id =?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);
            ResultSet results = stmt.executeQuery();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            Session record = new Session();
            record.setId(results.getInt("id"));
            record.setDuration(results.getInt("duration"));
            return Optional.of(record);
        } catch (SQLException e) {
            return Optional.empty();
//            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Session> listAll() {
        String sqlCommand = "select * from Session;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.executeQuery();

            List<Session> records = new ArrayList<>();

            while (rs.next()) {
                Session record = new Session();
                record.setId(rs.getInt(1));
                record.setDuration(rs.getInt(2));
                records.add(record);
            }

            return records;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


    }

    @Override
    public Optional<Session> update(int sessionId, Session record) {
        return Optional.empty();
    }

    @Override
    public boolean delete(int sessionId) {

        String sqlCommand = "DELETE FROM Session WHERE id=?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, sessionId);
            ResultSet results = stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


//    public String save(Session record){
//        PreparedStatement st = null;
//        ResultSet rs = null;
//
//
//        String sqlCommand = "insert into Session (duration) values(?);";
//
//        try {
//            st = conn.prepareStatement(sqlCommand,
//                    Statement.RETURN_GENERATED_KEYS );
//            st.setInt(1,record.getDuration());
//            st.execute();
////            rs = st.getGeneratedKeys();
////            rs.next(); // Assume just one auto-generated key; otherwise, use a while loop here
////            int index = rs.getInt(1);
////            record.setId(index);
//            return "OK";
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "Query Failed! Check output console";
//        }
//        finally
//        {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) { /* ignored */}
//            }
//            if (st != null) {
//                try {
//                    st.close();
//                } catch (SQLException e) { /* ignored */}
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) { /* ignored */}
//            }
//        }
//
//    }


}
