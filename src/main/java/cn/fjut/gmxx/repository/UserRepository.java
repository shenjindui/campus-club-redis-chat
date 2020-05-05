package cn.fjut.gmxx.repository;

import cn.fjut.gmxx.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WJ on 2019/3/27 0027
 */
@Repository
public interface UserRepository extends JpaRepository<SysUserEntity,Integer>, JpaSpecificationExecutor<SysUserEntity> {


    SysUserEntity findByLoginName(String loginName);

}
