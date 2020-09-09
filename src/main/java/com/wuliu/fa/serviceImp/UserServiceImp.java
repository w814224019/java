package com.wuliu.fa.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuliu.fa.Exception.ServiceException;
import com.wuliu.fa.entity.User;
import com.wuliu.fa.mapper.UserMapper;
import com.wuliu.fa.service.IUserService;


@Service
@Transactional
public class UserServiceImp implements IUserService{
@Autowired
UserMapper userMapper;
private User findByUserName(String username){
	return userMapper.findByUserName(username);
}
/*	@Override
	public Integer save(User user) {
     Integer i=addNewUser(user);

		return i;
	}
private Integer addNewUser(User user){
	return userMapper.addNewUser(user);
}

private List<Integer> findyId(){
	return userMapper.findyId();
}
private List<User> findUser(){
	return userMapper.findyUser();
}
*/


@Override
public User findByUName(String username) {
	User u=findByUserName(username);
	return u;
}
/*@Override
public List<Integer> getUid() {
	List l=findyId();
	return l;
}*/
/*@Override
public List<User> getUser() {
	List users=findUser();
	return users;
}*/
private User findById(Integer rid){
	return userMapper.findById(rid);
}
@Override
public User getById(Integer rid) {
	User a=findById(rid);
	if(a==null){
		throw new ServiceException("没有找到主键id为："+rid+"用户！");
	}
	return a;
}
private Integer updateUser(User u,Integer rid){
	String name=u.getName();
	Integer companyid=u.getCompanyid();
	String mobile=u.getMobile();
	String permissionid=u.getPermissionid();
	String password=u.getPassword();
	String address=u.getAddress();
	Integer delFlag=u.getDelFlag();
	String headimgurl=u.getHeadimgurl();
	return userMapper.updateUser( name,  companyid, mobile, 
			permissionid, password,  address,
			 headimgurl, delFlag,rid);
			
          }

@Override
public Integer UpdateUserInfo(User u, Integer rid) {
	Integer a=updateUser(u, rid);
	return a;
}
/*
@Override
public List<User> GetbycompanyId(Integer companyId) {
	return userMapper.findbycompanyId(companyId);
}
*/


@Override
public Integer addUser(User user) {
	Integer addU=userMapper.addNewUser(user);
	return addU;
}


@Override
public User findByphone(String phone) {
	User findB=userMapper.findByphone(phone);
	return findB;
}
	
	
	
	
}
