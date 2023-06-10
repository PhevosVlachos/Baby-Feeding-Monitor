package gr.athtech.babyfeed.repository;



import gr.athtech.babyfeed.model.Session;

import java.sql.*;

public class RecordRepositoryImpl implements RecordRepository{


    private static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB";
    private static final String USER = "root";
    private static final String PASS = "1234";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    @Override
    public void save(Session record) {


        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sqlCommand = "insert into Session (duration) values(?);";

        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS );
        ) {
            stmt.setInt(1,record.getDuration());
            stmt.execute();
            ResultSet results = stmt.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            int index = results.getInt(1);
            record.setId(index);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
