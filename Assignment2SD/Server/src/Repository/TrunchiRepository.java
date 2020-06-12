package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.TrunchiPiramida;

public class TrunchiRepository {
	private final JDBConnectionWrapper jdbConnectionWrapper;

	public TrunchiRepository(JDBConnectionWrapper jdbConnectionWrapper) {
		this.jdbConnectionWrapper = jdbConnectionWrapper;
	}

	public TrunchiPiramida find(String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		TrunchiPiramida p = new TrunchiPiramida();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Trunchi WHERE nume_figura=?");
			preparedStatement.setString(1, numeFigura);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				p.setId(resultSet.getInt(1));
				p.setH(resultSet.getDouble(3));
				p.setLMic(resultSet.getDouble(4));
				p.setL(resultSet.getDouble(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean save(TrunchiPiramida p, String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO Trunchi (nume_figura, inaltime_trunchi, latura_mica, latura_mare) VALUES(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, numeFigura);
			preparedStatement.setDouble(2, p.getH());
			preparedStatement.setDouble(3, p.getLMic());
			preparedStatement.setDouble(4, p.getL());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
