package com.mhomecare.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;
import com.mhomecare.customer.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponse> customerRegister(@RequestBody CustomerRequest customerRequest) {
		CustomerResponse customerResponse = customerService.registerCustomer(customerRequest);
		ResponseEntity<CustomerResponse> response = new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
		return response;
	}
}
