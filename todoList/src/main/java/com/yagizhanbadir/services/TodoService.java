package com.yagizhanbadir.services;

import java.util.List;
import java.util.UUID;

import com.yagizhanbadir.model.Todo;

public class TodoService {

//private static List<Todo> todos = new ArrayList<Todo>();

	private TodoDao todoDao = new TodoDaoDatabaseImpl();

	// ok.
	public List<Todo> retrieveTodos(String userId) {
		// List<Todo> userTodo = new ArrayList<Todo>();
//
//		for (Todo todo : todos) {
//
//			if (userId.equals(todo.getUserId())) {
//				userTodo.add(todo);
//			}
//		}
//		return userTodo;
		return todoDao.retrieveTodo(userId);
	}

	// ok.
	public void addTodo(String userUuid, String todo, String category) {

		String todoUuid = UUID.randomUUID().toString();
		// Todo newTodos = new Todo(userUuid, todo, category, id);
		// todos.add(newTodos);
		todoDao.addTodo(userUuid, todoUuid, todo, category);
	}
	//ok.
	public void deleteTodo(String uuid) {

		// Todo deletedTodos = new Todo(null, null, null, uuid);
		// todos.remove(deletedTodos);
		todoDao.deleteTodo(uuid);
	}
	
	//ok.
	public Todo getTodoWithId(String todoId) {
//
//		for (Todo t : todos) {
//			if (t.getUuid().equals(todoId))
//				return t;
//		}
//		return null;

		return todoDao.getTodoById(todoId);
	}

	//ok.
	public void updateTodo(String todoUuid, String newTodo, String newCategory) {
	//	Todo t = getTodoWithId(todoUuid);
	//	t.setName(newTodo);
	//	t.setCategory(newCategory);
		
		todoDao.updateTodo(todoUuid, newTodo, newCategory);
	}

}
