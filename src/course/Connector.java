package course;


import java.sql.SQLException;

public class Connector {

	public static void main(String[] args) throws SQLException {
		Database db = new Database();
		db.getConnection();
	}

}
