package com.wuliu.fa.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuliu.fa.entity.User;


public interface UserMapper {
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
	Integer addNewUser(User user);
	/**
	 * 更新修改信息
	 */
	Integer updateUser(@Param("name")String name,@Param("companyid")Integer companyid,
			@Param("mobile")String mobile,@Param("permissionid")String permissionid,@Param("password")String password,
			@Param("address")String address,@Param("headimgurl")String headimgurl,@Param("del_flag")Integer delFlag
			,@Param("rid")Integer rid
			);
	/**
	 * 通过id找用户
	 * @param rid
	 * @return
	 */
	User findById(Integer rid);
	/**
	 * 根据用户名查找用户信息
	 * @param username
	 * @return
	 */
	User findByUserName(String name);

	/**
	 * 批量添加
	 */
	Integer addPathers(List<User> pa);



}
