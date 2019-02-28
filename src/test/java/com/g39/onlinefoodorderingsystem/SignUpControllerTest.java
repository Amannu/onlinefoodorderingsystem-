package com.oles.olesteam;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SignUpControllerTest {

	  private static HtmlUnitDriver browser;
	  
	  @LocalServerPort
	  private int port;
	  
	  @Autowired
	  TestRestTemplate rest;
	  
	  @BeforeClass
	  public static void setup() {
	    browser = new HtmlUnitDriver();
	    browser.manage().timeouts()
	        .implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	  @AfterClass
	  public static void closeBrowser() {
	    browser.quit();
	  }
	  
	  @Test
	  public void Test_SignUpPage_Correct() throws Exception {
	    browser.get(homePageUrl());
	    clickSignUp();
	    assertSignUpPage();
	    buildAndSubmitAUser();
	  }
	  
	  
	  public void clickSignUp() {
		  browser.findElementByCssSelector("a[href='/register']").click();
	  }
	  private String homePageUrl() {
		    return "http://localhost:" + port + "/";
	  }
	  
	  private String SignUpPageUrl() {
		  return homePageUrl()+"register";
	  }
	  
	  private void assertSignUpPage() {
		    assertEquals(SignUpPageUrl(), browser.getCurrentUrl());
	  }
}
