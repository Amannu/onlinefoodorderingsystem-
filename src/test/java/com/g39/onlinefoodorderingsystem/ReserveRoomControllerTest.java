package com.g39.onlinefoodorderingsystem;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.apache.tomcat.util.http.parser.Cookie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@ContextConfiguration(classes=ReserveRoomControllerTest.class)
@RunWith(SpringRunner.class)
@WebMvcTest  // <1>
public class ReserveRoomControllerTest {

  @Autowired
  private MockMvc mockMvc;   // <2>

  @Test
 
  public void testOrderControllerGet() throws Exception {
	  
	  HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
	  CsrfToken csrfToken = httpSessionCsrfTokenRepository.generateToken(new MockHttpServletRequest());
	  
	  
	  
	  javax.servlet.http.Cookie c = result.getResponse().getCookie("JSESSIONID");
	  mockMvc.perform(get("/order").cookie(c)).andExpect(status().isOk())
	  
	     // <3>
    
      .andExpect(status().isOk())  // <4>
      
      .andExpect(view().name("order"))  // <5>
      
      .andExpect(content().string(           // <6>
          containsString("order")));  
  }
  
  @Test
  public void testReserveRoomControllerPost() throws Exception {
    

    mockMvc.perform(post("/order")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().stringValues("Location", "/"));
  }


}
