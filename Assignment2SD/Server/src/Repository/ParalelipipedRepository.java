package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.ParalelipipedDreptunghic;

public class ParalelipipedRepository {
	private final JDBConnectionWrapper jdbConnectionWrapper;

	public ParalelipipedRepository(JDBConnectionWrapper jdbConnectionWrapper) {
		this.jdbConnectionWrapper = jdbConnectionWrapper;
	}

	public ParalelipipedDreptunghic find(String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		ParalelipipedDreptunghic p = new ParalelipipedDreptunghic();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Paralelipiped WHERE nume_figura=?");
			preparedStatement.setString(1, numeFigura);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				p.setId(resultSet.getInt(1));
				p.setLMic(resultSet.getDouble(3));
				p.setL(resultSet.getDouble(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean save(ParalelipipedDreptunghic p, String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO Paralelipiped (nume_figura, latura_mica, latura_mare) VALUES(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, numeFigura);
			preparedStatement.setDouble(2, p.getLMic());
			preparedStatement.setDouble(3, p.getL());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
