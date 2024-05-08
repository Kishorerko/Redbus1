package com.example.kishorerko.redbus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kishorerko.redbus.dto.CXPData;
import com.example.kishorerko.redbus.dto.RedbusRequest;
import com.example.kishorerko.redbus.dto.RedbusRequestUI;
import com.example.kishorerko.redbus.dto.RedbusResponseUI;
import com.example.kishorerko.redbus.dto.RedisData;
import com.example.kishorerko.redbus.serviceImpl.RedBusServicesImpl;

@RestController
@RequestMapping("/redbus")
public class RedbusController {
	
	private static final Logger logger = LoggerFactory.getLogger(RedbusController.class);

	@Autowired
	RedBusServicesImpl service;

	@PostMapping("/saveBusDetails")
	public ResponseEntity<RedbusResponseUI> saveRedBusDetails(@RequestBody RedbusRequestUI request) {
		return service.saveRedBusDetails(request);
	}

	@PostMapping("/saveAllbusDetails")
	public ResponseEntity<RedbusResponseUI> saveAllRedBusDetails(@RequestBody List<RedbusRequestUI> requestList) {
		return service.saveAllRedBusDetails(requestList);
	}

	@GetMapping("/getAllBusDetails")
	public ResponseEntity<List<RedbusRequest>> getAllBusDetails() {
		return service.getAllBusDetails();
	}

	@GetMapping("/getBusDetails/{id}")
	public RedbusRequest getBusDetails(@PathVariable int id) {
		return service.getBusDetails(id);
	}

	@DeleteMapping("/deleteBusDetails/{id}")
	public String deleteBusDetails(@PathVariable long id) {
		return service.deleteBusDetails(id);
	}

	@PutMapping("/updateBusDetails/{id}")
	public RedbusRequest updateBusDetails(@PathVariable long id, @RequestBody RedbusRequestUI request) {

		return service.updateBusDetails(id, request);
	}
	
	@PostMapping("/test")
	public CXPData testMethod(@RequestBody RedisData uiRequest) {
		logger.info("Inside the test controller");
		return service.testMethod(uiRequest);
	}
	
}
