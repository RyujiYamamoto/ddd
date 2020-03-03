package com.yamari.idddd.repository.inMemory;

import java.util.HashMap;
import java.util.Map;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;
import com.yamari.idddd.domain.models.users.UserName;

public class InMemoryUserRepository implements IUserRepository
{

	public Map<UserId, User> store = new HashMap<UserId, User>();
	
	@Override
	public void save(User user){
		//�ۑ����̓f�B�[�v�R�s�[
		store.put(user.id, clone(user));
	}

	@Override
	public User find(UserName name){
		return store.values().stream()
			.filter((i -> name.equals(i.name)))
			.findFirst()
			.orElse(null);
	}
	
	private User clone(User user) {
		return new User(user.id, user.name);
	}
}