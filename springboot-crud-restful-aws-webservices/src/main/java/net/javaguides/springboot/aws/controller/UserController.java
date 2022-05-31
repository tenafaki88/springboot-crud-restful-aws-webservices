package net.javaguides.springboot.aws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.aws.entity.User;
import net.javaguides.springboot.aws.exception.ResourceNotFoundException;
import net.javaguides.springboot.aws.repository.UserRepository;

@RestController  // @RestController =  @Controller + @ResponseBody
// We're using Spring MVC to develop this Controller layer
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	// We'll use crud database operations from our UserRepository Interface
	// get all users REST API
	
	@GetMapping
	public List<User> getAllUsers() {
		//findAll() method returns list of all User Objects
		return userRepository.findAll();  // findAll() method returns list of all User Objects
	}
	
	// get user by id REST API
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(name = "id") Long userId) {
		// we return user object
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not Found with id : " + userId));  
	}
	
	// create user POST REST API
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user); // This will save the user object into the DB.
	}
	 
	// update user REST API
	@PutMapping("/{id}")
	// Where user is our new user object
	public User updateUser(@RequestBody User user, @PathVariable(name = "id") Long userId) {
		// First let us make sure our new user object("user") exists in our DB
		User existingUser = getUserById(userId);
		// Let's update the existing user object
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		return this.userRepository.save(existingUser);
		
	}
	
	// delete user by id REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserA(@PathVariable(name = "id") Long userId) {
		// First let us make sure our new user object("user") exists in our DB
		User existingUser = getUserById(userId);
//		this.userRepository.deleteById(existingUser.getId());
//		return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();		
	}
	
//	// delete user by id REST API
//	@DeleteMapping("/{idx}")
//	public ResponseEntity<String> deleteUserB(@PathVariable(name = "idx") Long userId) {
//		// First let us make sure our new user object("user") exists in our DB
//		User existingUser = getUserById(userId);
//		this.userRepository.deleteById(existingUser.getId());
//		return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
//		
//	}


}
