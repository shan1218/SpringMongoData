package com.sony.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sony.dto.UserVO;
import com.sony.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private static final String CLASS_NAME = UserController.class.getSimpleName();
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/createOrUpdate")
	public ResponseEntity<UserVO> createOrUpdate(@RequestBody UserVO userVO) {
		final String METHOD_NAME = "createOrUpdate";
		try {
			return new ResponseEntity<UserVO>(userService.createOrUpdate(userVO), HttpStatus.OK);
		} catch (Exception exception) {
			throw exception;
		}
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteUser(@RequestParam("id") String id) {
		final String METHOD_NAME = "deleteUser";
		try {
			LOGGER.info("Delete user with userId : {}",id);
			return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
		} catch (Exception exception) {
			throw exception;
		}
	}
	
	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<UserVO>> getUsers() {
		final String METHOD_NAME = "getUsers";
		try {
			return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
		} catch (Exception exception) {
			throw exception;
		}
	}
	
	@PostMapping(value = "/getUsersByPage")
	public ResponseEntity<List<UserVO>> getUsersByPage(@RequestBody UserVO userVO) {
		final String METHOD_NAME = "getUsersByPage";
		try {
			return new ResponseEntity<>(userService.getUsersByPage(userVO), HttpStatus.OK);
		} catch (Exception exception) {
			throw exception;
		}
	}
}
