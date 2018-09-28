package com.yagizhanbadir.services;

import java.util.List;

import com.yagizhanbadir.model.Todo;

public interface TodoDao {

	public List<Todo> retrieveTodo(String userId);
	public void addTodo(String userUuid, String todoUuid, String todo, String category);
	public void deleteTodo(String todoUuid);
	public Todo getTodoById(String todoId);
	public void updateTodo(String newTodo, String newCategory, String todoUuid);
	
}
