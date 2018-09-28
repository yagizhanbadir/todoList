package com.yagizhanbadir.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yagizhanbadir.model.Todo;

public class TodoDaoDatabaseImpl implements TodoDao {

	private String kullanici_adi = "root";
	private String parola = "";
	private String db_ismi = "todolist"; // Database name
	private String host = "localhost";
	private int port = 3306;
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public TodoDaoDatabaseImpl() {

		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi + "?useUnicode=true&characterEncoding=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Driver Bulunamadý...");
		}

		try {
			con = DriverManager.getConnection(url, kullanici_adi, parola);
			System.out.println("Baðlantý Baþarýlý...");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Todo> retrieveTodo(String userId) {
		List<Todo> TodoList = new ArrayList<Todo>();

		String sorgu = "SELECT todoUuid, todo, category FROM todo WHERE userUuid=?";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String todo = rs.getString("todo");
				String category = rs.getString("category");
				String todoUuid = rs.getString("todoUuid");
				Todo todoObject = new Todo(null, todo, category, todoUuid);

				if (!TodoList.contains(todoObject)) {
					TodoList.add(todoObject);
				}

			}
			return TodoList;
		} catch (

		SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addTodo(String userUuid, String todoUuid, String todo, String category) {

		try {
			statement = con.createStatement();
			String sorgu = "INSERT INTO todo(userUuid, todoUuid, todo, category) VALUES(" + "'" + userUuid + "'," + "'"
					+ todoUuid + "'," + "'" + todo + "'," + "'" + category + "')";
			statement.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTodo(String todoUuid) {
		String sorgu = "DELETE FROM todo WHERE todoUuid=?";

		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, todoUuid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Todo getTodoById(String todoId) {
		Todo todoObject = null;
		String sorgu = "SELECT *FROM todo WHERE todoUuid=?";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, todoId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				String todo = rs.getString("todo");
				String category = rs.getString("category");
				String todoUuid = rs.getString("todoUuid");
				String userUuid = rs.getString("userUuid");
				todoObject = new Todo(userUuid, todo, category, todoUuid);
				return todoObject;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return todoObject;
	}

	public void updateTodo(String newTodo, String newCategory, String todoUuid) {

		String sorgu = "UPDATE todo SET todo=?, category=? WHERE todoUuid=?";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(3, newTodo);
			preparedStatement.setString(1, newCategory);
			preparedStatement.setString(2, todoUuid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	}
