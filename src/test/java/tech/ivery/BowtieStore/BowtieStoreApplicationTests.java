package tech.ivery.BowtieStore;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import tech.ivery.BowtieStore.services.UserServImpl;

@SpringBootTest
class BowtieStoreApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserServImpl userv;
	
	@Test
	void contextLoads() throws Exception {
	}

}
