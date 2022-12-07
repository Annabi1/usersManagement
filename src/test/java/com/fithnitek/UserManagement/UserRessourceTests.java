package com.fithnitek.UserManagement;

import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fithnitek.UserManagement.model.ERole;
import com.fithnitek.UserManagement.model.Role;
import com.fithnitek.UserManagement.model.User;
import com.fithnitek.UserManagement.rest.UserResource;
import com.fithnitek.UserManagement.service.UserServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebMvcTest(controllers = UserResource.class)
public class UserRessourceTests {
	@Autowired
	private UserResource userRessource;
	@Mock
	private com.fithnitek.UserManagement.repository.UserRepository userRepo;
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private UserServiceImpl userService;

	@Test
	public void testWelcome() throws Exception {
		this.mockmvc.perform(MockMvcRequestBuilders.get("/api/users/"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());

	}
	
	  @Test public void deleteEmployeeAPI() throws Exception { mockmvc.perform(
	  MockMvcRequestBuilders.delete("/api/users/{id}", "annabi.mabrouka99@gmail.com") )
	  .andExpect(status().isAccepted()); }
	 
	/*
	 * @Test public void getEmployeeByIdAPI() throws Exception { mockmvc.perform(
	 * MockMvcRequestBuilders .get("/employees/{id}", 1)
	 * .accept(MediaType.APPLICATION_JSON)) .andDo(print())
	 * .andExpect(status().isOk())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(1)); }
	 */
	
	  @Test public void createUserAPI() throws Exception { mockmvc.perform(
	  MockMvcRequestBuilders .post("/api/users/") .content(asJsonString(new User()))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
	  .andExpect(status().isCreated())
	  .andExpect(MockMvcResultMatchers.jsonPath("").exists()); }
	  
	  
	  
	  
	  public static String asJsonString(final Object obj) { try { return new
	  ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
	  RuntimeException(e); } }
	 

}
