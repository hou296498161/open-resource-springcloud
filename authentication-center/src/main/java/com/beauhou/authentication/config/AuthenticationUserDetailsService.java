package com.beauhou.authentication.config;

//import com.beauhou.authentication.dao.UserMapper;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beauhou.authentication.dao.UserMapper;
import com.beauhou.authentication.eo.T_USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/2 0002 16:06
 * 用户接口，当使用密码模式时，调用此方法进行用户校验
 */
@Component
public class AuthenticationUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<T_USER> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",s);
        T_USER t_user = userMapper.selectOne(queryWrapper);
        if (t_user!=null){
            UserDetails userDetails = User.builder().username(JSON.toJSONString(t_user)).password(t_user.getPassword()).authorities("test").build();
            return userDetails;
        }
        //模拟用户
        return null;
    }
}
