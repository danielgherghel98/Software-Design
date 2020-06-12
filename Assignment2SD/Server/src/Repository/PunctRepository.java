package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Punct;

public class PunctRepository {

	private final JDBConnectionWrapper jdbConnectionWrapper;

	public PunctRepository(JDBConnectionWrapper jdbConnectionWrapper) {
		this.jdbConnectionWrapper = jdbConnectionWrapper;
	}

	public ArrayList<Punct> findAll(String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		ArrayList<Punct> puncte = new ArrayList<Punct>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Punct WHERE nume_figura=?");
			preparedStatement.setString(1, numeFigura);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Punct punct = new Punct();

				punct.setX(resultSet.getInt(3));
				punct.setY(resultSet.getInt(4));

				puncte.add(punct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return puncte;
	}

	public boolean saveAll(ArrayList<Punct> puncte,String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		try {
			for (Punct punct : puncte) {
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO Punct (nume_figura, punct_x, punct_y) VALUES(?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, numeFigura);
				preparedStatement.setInt(2, punct.getX());
				preparedStatement.setInt(3, punct.getY());

				preparedStatement.execute();
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Punct WHERE nume_figura=?");
			preparedStatement.setString(1, numeFigura);

			int updatedRows = preparedStatement.executeUpdate();

			return updatedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
