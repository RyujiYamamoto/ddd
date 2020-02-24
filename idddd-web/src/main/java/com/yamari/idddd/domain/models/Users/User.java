package com.yamari.idddd.domain.models.Users;

import java.util.Objects;

class User {
	private UserId id;
	private UserName name;
		
	public User(UserId id, UserName name) {
		if (id == null) {
			throw new IllegalArgumentException("id�͕K�����͂��Ă��������B");
		}
		
		this.id = id;
		this.changeName(name);
	}
		
	public void changeName(UserName name) {
		if (name == null) {
			throw new IllegalArgumentException("name�͕K�����͂��Ă��������B");
		}
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true;	}
		if (obj == null) { return false; }
		if (!(obj instanceof User)) { return false;	}
		
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
