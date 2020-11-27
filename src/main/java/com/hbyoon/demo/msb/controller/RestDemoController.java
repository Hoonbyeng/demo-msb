package com.hbyoon.demo.msb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbyoon.demo.msb.dto.RestDemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/msb")
public class RestDemoController {
	
	@GetMapping(value={"", "/{id}"})
	public RestDemo hello(@PathVariable(name="id", required=false) String id) {
		RestDemo d = new RestDemo();
		d.setId(id);
		d.setName("msB");
		d.setDescription("this is msb.");
		log.debug("I am msB : got {}, dending {}", id, d);
		return d;
	}

	@GetMapping("error/{id}")
	public RestDemo error(String id) {
		throw new RuntimeException("ERROR");
	}

	@PostMapping("/put")
	public RestDemo update(@RequestBody RestDemo demo) {
		RestDemo d = new RestDemo();
		d.setId(demo.getId());
		d.setName(demo.getName());
		d.setDescription("[UPDATED] result from msa.");
		return d;
	}
	
	@GetMapping("/waiting")
	public RestDemo waiting() {
		try {
			Thread.sleep(22000L);
		} catch (Exception e) {
			// TODO: handle exception
		}
		RestDemo d = new RestDemo();
		return d;
	}
	
}
