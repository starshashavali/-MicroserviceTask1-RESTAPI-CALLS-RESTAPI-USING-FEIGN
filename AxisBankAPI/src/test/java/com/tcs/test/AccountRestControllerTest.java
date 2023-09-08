package com.tcs.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.tcs.restcontroller.AccountRestController;
import com.tcs.service.AccountServiceImpl;

@WebMvcTest(controllers = AccountRestController.class)
public class AccountRestControllerTest {

	@MockBean
	private AccountServiceImpl accountService;
	@Autowired
	private MockMvc mockMvc;

	
}
