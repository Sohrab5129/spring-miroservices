package com.sohrab.rentcloud.rentui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.sohrab.rentcloud.commons.model.Customer;
import com.sohrab.rentcloud.rentui.config.AccessToken;

@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/")
	public String loadUI() {
		return "home";
	}

	@GetMapping(value = "/secure")
	public String loadSecuredUI() {
		return "secure";
	}

	@GetMapping(value = "/customers")
	public String loadSCustomers(Model model) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", AccessToken.getAccessToken());

		HttpEntity<Customer> entity = new HttpEntity<Customer>(httpHeaders);

		try {

			ResponseEntity<Customer[]> responseEntity = restTemplate
					.exchange("http://localhost:9191/services/customers", HttpMethod.GET, entity, Customer[].class);
			model.addAttribute("customers", responseEntity.getBody());
		} catch (HttpStatusCodeException e) {
			ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
					.body(e.getResponseBodyAsString());
			model.addAttribute("error", responseEntity);
		}

		return "secure";
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
	}
}
