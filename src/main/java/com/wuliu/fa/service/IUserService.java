package com.wuliu.fa.service;


import org.springframework.stereotype.Service;

import com.wuliu.fa.entity.User;





@Service
public interface IUserService {
	/**
	 * 通过手机号找用户
	 * @param 
	 * @return
	 */
	User findByphone(String  phone);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	Integer addUser(User user);
	 /**
     * 更新用户信息
     */
    Integer UpdateUserInfo(User u,Integer rid);
	   /**
     * 通过用户rid
     * 找用户
     * @param rid
     * @return
     */
    User getById(Integer rid);
	/**
	 * 通过用户名找用户
	 * @param username
	 * @return
	 */
    User findByUName(String username);
    
}
