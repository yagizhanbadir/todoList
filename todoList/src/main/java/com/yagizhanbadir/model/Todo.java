package com.yagizhanbadir.model;


public class Todo {

	private String userId;
	private String todo;
	private String category;
	private String todoUuid;

	public Todo(String userId, String name, String category, String todoUuid) {
		super();
		this.todo = name;
		this.category = category;
		this.todoUuid = todoUuid;
		this.userId = userId;
	}

	public String getName() {
		return todo;
	}

	public void setName(String name) {
		this.todo = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUuid() {
		return todoUuid;
	}

	public void setUuid(String uuid) {
		this.todoUuid = uuid;
	}

	@Override
	public String toString() {
		return String.format("Todo [name=%s, category=%s]", todo, category);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((todoUuid == null) ? 0 : todoUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (todoUuid == null) {
			if (other.todoUuid != null)
				return false;
		} else if (!todoUuid.equals(other.todoUuid))
			return false;
		return true;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
