package com.sony.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.sony.collection.User;
import com.sony.dto.UserVO;
import com.sony.repository.UserRepository;

@Service
public class UserService {

	private Sort sort = new Sort(Sort.Direction.ASC, "userName");
	
	@Autowired
	private UserRepository userRepository;

	public UserVO createOrUpdate(UserVO userVO) {
		final String METHOD_NAME = "createOrUpdate";
		User user = new User();
		try {
			BeanUtils.copyProperties(userVO, user);
			user = userRepository.save(user);
			BeanUtils.copyProperties(user, userVO);
		} catch (Exception exception) {
			throw exception;
		}
		return userVO;
	}

	public String deleteUser(String id) {
		final String METHOD_NAME = "deleteUser";
		try {
			userRepository.deleteById(id);
			return "{\"Message\":\"Success\"}";
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return "{\"Message\":\"Failure\"}";
	}
	
	@GetMapping(value = "/getUsers")
	public List<UserVO> getUsers() {
		final String METHOD_NAME = "getUsers";
		List<UserVO> userVoList = new ArrayList<UserVO>();
		try {
			List<User> userList = userRepository.findAll(sort);
			for (User user : userList) {
				UserVO userVo = new UserVO();
				BeanUtils.copyProperties(user, userVo);
				userVoList.add(userVo);
			}
			return userVoList;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return new ArrayList<UserVO>(); 
	}
	
	public List<UserVO> getUsersByPage(UserVO userVO) {
		final String METHOD_NAME = "getUsersByPage";
		List<UserVO> userVoList = new ArrayList<UserVO>();
		try {
			Pageable pageable = new PageRequest(userVO.getCurrentPage(), userVO.getItemPerPage(), Sort.Direction.ASC,"userName");
			Page<User> userList = userRepository.findAll(pageable);
			for (User user : userList) {
				UserVO userVo = new UserVO();
				BeanUtils.copyProperties(user, userVo);
				userVoList.add(userVo);
			}
			return userVoList;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return new ArrayList<UserVO>(); 
	}
}