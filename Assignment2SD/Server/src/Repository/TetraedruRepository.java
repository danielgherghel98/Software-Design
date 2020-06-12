package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Prisma;
import Model.Tetraedru;

public class TetraedruRepository {
	private final JDBConnectionWrapper jdbConnectionWrapper;

	public TetraedruRepository(JDBConnectionWrapper jdbConnectionWrapper) {
		this.jdbConnectionWrapper = jdbConnectionWrapper;
	}

	public Tetraedru find(String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		Tetraedru p = new Tetraedru();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Tetraedru WHERE nume_figura=?");
			preparedStatement.setString(1, numeFigura);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				p.setId(resultSet.getInt(1));
				p.setH(resultSet.getDouble(3));
				p.setL(resultSet.getDouble(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean save(Tetraedru p, String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO Tetraedru (nume_figura, inaltime_tetraedru, latura_tetraedru) VALUES(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, numeFigura);
			preparedStatement.setDouble(2, p.getH());
			preparedStatement.setDouble(3, p.getL());
			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
