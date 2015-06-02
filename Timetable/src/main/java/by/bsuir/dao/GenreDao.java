package by.bsuir.dao;

import java.sql.SQLException;
import java.util.List;

import by.bsuir.entity.*;

public interface GenreDao<Type> {

	public void addGenre(Type generic) throws SQLException;

	public void deleteGenre(Type generic) throws SQLException;

	public Type getGenre(int id) throws SQLException;

	public List<Type> getAll() throws SQLException;

}
