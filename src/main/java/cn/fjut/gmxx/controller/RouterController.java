package cn.fjut.gmxx.controller;

import cn.fjut.gmxx.constant.CommonConstant;
import cn.fjut.gmxx.entity.SysUserEntity;
import cn.fjut.gmxx.entity.User;
import cn.fjut.gmxx.service.ChatSessionService;
import cn.fjut.gmxx.exception.GlobalException;
import cn.fjut.gmxx.service.ISysUserService;
import cn.fjut.gmxx.utils.BaseAppAction;
import cn.fjut.gmxx.utils.R;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * 路由接口控制器
 *
 */
@Slf4j
@Controller
public class RouterController extends BaseAppAction{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ChatSessionService chatSessionService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 登陆页面
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "login";
    }

    /**
     * 登录接口
     *
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        Set<String> keys = redisTemplate.keys(CommonConstant.USER_PREFIX + CommonConstant.REDIS_MATCH_PREFIX);
        SysUserEntity sysUserEntity=sysUserService.getSysUserByMapWithJpa(user.getName());
        if(sysUserEntity==null){
            throw new GlobalException("用户名不存在");
        }
        if (keys != null && keys.size() > 0) {
            keys.forEach(key -> {
                User entity = chatSessionService.findById(key);
                if (entity != null) {
                    if ((entity.getName()).equals(user.getName())) {
                        //throw new GlobalException("用户名已存在");
                        chatSessionService.delete(String.valueOf(entity.getId()));
                    }
                }
            });
        }
        redisTemplate.boundValueOps(CommonConstant.USER_PREFIX + user.getId()).set(JSONObject.toJSONString(user));
        return successResponse(null);
    }

    /**
     * 首页入口
     *
     * @return
     */
    @GetMapping("/{id}/chat")
    public String index(@PathVariable("id") String id) {
        User user = chatSessionService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        return "index";
    }
}
