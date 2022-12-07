package com.fithnitek.UserManagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithnitek.UserManagement.model.Role;
import com.fithnitek.UserManagement.model.User;
import com.fithnitek.UserManagement.repository.RoleRepository;
import com.fithnitek.UserManagement.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements  IUserService {
@Autowired
private UserRepository userRepo;

@Autowired
private RoleRepository roleRepo;

@Override
public User save(User user) {
 User userSerched=userRepo.findUserByEmail(user.getEmail());
if(userSerched==null)
{
	return userRepo.save(user);

}
return null;
}

@Override
public List<User> findAll() {
	// TODO Auto-generated method stub
	return userRepo.findAll();
}

@Override
public void delete(String email) {
	// TODO Auto-generated method stub
	userRepo.deleteById(email);
}

@Override
public Optional<User> getUserByEmail(String email) {
	// TODO Auto-generated method stub
	return userRepo.findById(email);
}

@Override
public User updateUser(String email,  User user) {
	Optional<User> userSearched=userRepo.findById(email);
	User userUpdated=userSearched.get();
	userUpdated.setFirstname(user.getFirstname());
	userUpdated.setLastname(user.getLastname());
	userUpdated.setEmail(user.getEmail());
	userUpdated.setImage(user.getImage());
user=userUpdated;
return userRepo.save(user);
}

@Override
public User updateUserEnabled(String id) {
 User userSerched=userRepo.findUserByEmail(id);
if (userSerched.isEnabled()==false)
        {

    
	userSerched.setEnabled(true);
        
	    }
else 
	userSerched.setEnabled(false);

return userSerched;
}
	
public List<Role>getAllRoles(){
	return roleRepo.findAll();
}

@Override
public Role getRoleByName(long id) {
	// TODO Auto-generated method stub
	return null;
}
}
