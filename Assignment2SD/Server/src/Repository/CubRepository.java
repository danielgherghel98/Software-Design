package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cub;
import Model.Punct;

public class CubRepository {
	private final JDBConnectionWrapper jdbConnectionWrapper;

	public CubRepository(JDBConnectionWrapper jdbConnectionWrapper) {
		this.jdbConnectionWrapper = jdbConnectionWrapper;
	}

	public Cub find(String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		Cub cub = new Cub();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Cub WHERE nume_figura=?");
			preparedStatement.setString(1, numeFigura);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				cub.setId(resultSet.getInt(1));
				cub.setL(resultSet.getDouble(3));
				System.out.println("Id:" + resultSet.getInt(1) + "   " + "Latura:" + resultSet.getDouble(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cub;
	}

	public boolean save(Cub cub, String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO Cub (nume_figura, latura_cub) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, numeFigura);
			preparedStatement.setDouble(2, cub.getL());

			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
