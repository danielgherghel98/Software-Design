package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnectionWrapper {
	
	private static final String url = "jdbc:mysql://localhost:3308/";
	private static final String username = "root";
	private static final String password = "";
    private static final int TIMEOUT = 5;
	
	private Connection connection;
	
	public JDBConnectionWrapper(String schemaName) {
        try {
            connection = DriverManager.getConnection(url + schemaName, username, password);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private void createTables() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "create table if not exists Cub (" + 
        		"	id int(4) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        		"	nume_figura varchar(20) UNIQUE NOT NULL," +
        		"	latura_cub double NOT NULL);";
        statement.execute(sql);
        
         sql = "create table if not exists Paralelipiped (" + 
        		"	id int(4) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        		"	nume_figura varchar(20) UNIQUE NOT NULL," +
        		"	latura_mica double NOT NULL," +
        		"	latura_mare double NOT NULL);";
        statement.execute(sql);
        
         sql = "create table if not exists Piramida (" + 
        		"	id int(4) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        		"	nume_figura varchar(20) UNIQUE NOT NULL," +
        		"	inaltime_piramida double NOT NULL," +
        		"	latura_piramida double NOT NULL);";
        statement.execute(sql);

         sql = "create table if not exists Prisma (" + 
        		"	id int(4) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        		"	nume_figura varchar(20) UNIQUE NOT NULL," +
        		"	inaltime_prisma double NOT NULL," +
        		"	latura_prisma double NOT NULL);";
        statement.execute(sql);
        
         sql = "create table if not exists Tetraedru (" + 
        		"	id int(4) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        		"	nume_figura varchar(20) UNIQUE NOT NULL," +
        		"	inaltime_tetraedru double NOT NULL," +
        		"	latura_tetraedru double NOT NULL);";
        statement.execute(sql);
        
         sql = "create table if not exists Trunchi (" + 
        		"	id int(4) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        		"	nume_figura varchar(20) UNIQUE NOT NULL," +
        		"	inaltime_trunchi double NOT NULL," +
        		"	latura_mica double NOT NULL," +
        		"	latura_mare double NOT NULL);";
        statement.execute(sql);
        
        sql = "create table if not exists Punct (" + 
        		"	id int(4) UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        		"	nume_figura varchar(20) NOT NULL," +
        		"	punct_x int NOT NULL," +
        		"	punct_y int NOT NULL);";
        statement.execute(sql);

       
       
        statement.execute(sql);
    }
	
	public boolean testConnection() throws SQLException {
        return connection.isValid(TIMEOUT); 
    }

    public Connection getConnection() {
        return connection;
    }
}

