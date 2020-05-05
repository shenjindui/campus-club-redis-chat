package cn.fjut.gmxx.service.impl;

import cn.fjut.gmxx.entity.SysUserEntity;
import cn.fjut.gmxx.repository.UserRepository;
import cn.fjut.gmxx.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @类名称 ISysUserService
* @类描述 <pre>请填写</pre>
* @作者 shenjindui 1
* @创建时间 2019-12-28
* @版本 vV1.0
* @修改记录
*
* 版本 修改人 修改时间 修改内容描述
* ----------------------------------------------
* V1.0 shenjindui 2019-12-28 新建
* ----------------------------------------------
*
*/
@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public SysUserEntity getSysUserByMapWithJpa(String loginName) {
		return userRepository.findByLoginName(loginName);
	}
}


