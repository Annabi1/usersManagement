package com.fithnitek.UserManagement;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.fithnitek.UserManagement.model.ERole;
import com.fithnitek.UserManagement.model.Role;
import com.fithnitek.UserManagement.repository.RoleRepository;

@DataJpaTest(showSql=true)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

public class RoleTests {
	@Autowired
	private RoleRepository repo;
	private ERole name;
	@Test
	public void testCreateFirstProfil() {
		Role admin = new Role( name.Livreur,"manage livriasion");	
			Role profilSaved = repo.save(admin);
			
	}
	
}
