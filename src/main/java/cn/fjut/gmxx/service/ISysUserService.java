package cn.fjut.gmxx.service;



import cn.fjut.gmxx.entity.SysUserEntity;

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
public interface ISysUserService {


    //JPA
	SysUserEntity getSysUserByMapWithJpa(String loginName);









}

