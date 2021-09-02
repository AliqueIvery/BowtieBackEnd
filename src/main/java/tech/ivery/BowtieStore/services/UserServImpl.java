package tech.ivery.BowtieStore.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ivery.BowtieStore.exceptions.UserNotFoundException;
import tech.ivery.BowtieStore.models.User;
import tech.ivery.BowtieStore.repositories.UserRepo;

@Service
public class UserServImpl implements UserService {
	private UserRepo uRepo;
	
	@Autowired
	public UserServImpl(UserRepo u) {
		this.uRepo = u;
	}
	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return uRepo.save(user);
	}

	@Override
	public User getUserById(Integer id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return uRepo.getUserById(id);
	}

	@Override
	public Set<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> list = uRepo.findAll();
		Set<User> set = new HashSet<>();
		set.addAll(list);
		return set;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			if(getUserById(user.getId()) != null) {
				uRepo.save(user);
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			if(getUserById(user.getId()) != null) {
				uRepo.delete(user);
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
