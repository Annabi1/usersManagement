package com.fithnitek.UserManagement.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fithnitek.UserManagement.model.FileUploadUtil;
import com.fithnitek.UserManagement.model.Role;
import com.fithnitek.UserManagement.model.User;
import com.fithnitek.UserManagement.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserResource {
	  private final Logger log =  LoggerFactory.getLogger(UserResource.class);
		private  final IUserService service;
	 
	 public UserResource(IUserService service) {
			super();
			this.service = service;
		}

	@GetMapping("/")
	    public  List<User> getAllUsers() {
	    log.debug("REST request to get all user");
	        return service.findAll();
	    }
	@GetMapping("/roles")
    public  List<Role> getAllRoles() {
        return service.getAllRoles();
    }
	@GetMapping("/roles/{id}")
    public  ResponseEntity<Role> getRoleById(@PathVariable long id) {
        Role role= service.getRoleByName(id);
        return ResponseEntity.ok()
                .body(role);
    }



	
	  @GetMapping(value = "/message", produces = MediaType.TEXT_PLAIN_VALUE)
	    @ResponseBody
	    public String message() {

	        return "Hello mabrouka!";
	    }
	  @PostMapping("/upload")
	    public String  uploadimage( @RequestParam("image") MultipartFile multipartFile) throws URISyntaxException, IOException {
	  System.out.println(multipartFile);
		  return "succes";
	  }
	@PostMapping("/")
    public ResponseEntity<User> createUser( @RequestBody User user) throws URISyntaxException, IOException {
 log.debug("REST request to save user : {}", user);
 User result=new User();
		  user.setEnabled(false);
	         result = service.save(user);		
        return ResponseEntity.created(new URI("/api/users/" + result))
                .body(result);
    }
	@GetMapping("/{id}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String id) {
  log.debug("REST request to get User : {}", id);
       java.util.Optional<User> user = service.getUserByEmail(id);
        return ResponseEntity.ok().body(user.get());
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
  log.debug("REST request to delete user : {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

  @PutMapping("/{id}")
    public ResponseEntity<User> updateUserEnabled(   @PathVariable String id, @RequestBody User user ) throws URISyntaxException {

        User result = service.updateUserEnabled(id);
        return ResponseEntity.ok()
                .body(result);
    }


}
