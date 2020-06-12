package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Piramida;
import Model.Prisma;

public class PrismaRepository {
	private final JDBConnectionWrapper jdbConnectionWrapper;

	public PrismaRepository(JDBConnectionWrapper jdbConnectionWrapper) {
		this.jdbConnectionWrapper = jdbConnectionWrapper;
	}

	public Prisma find(String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		Prisma p = new Prisma();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Prisma WHERE nume_figura=?");
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

	public boolean save(Prisma p, String numeFigura) {
		Connection connection = jdbConnectionWrapper.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO Prisma (nume_figura, inaltime_prisma, latura_prisma) VALUES(?, ?, ?)",
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
