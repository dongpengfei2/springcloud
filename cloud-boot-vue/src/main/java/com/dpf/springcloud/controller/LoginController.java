package com.dpf.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dpf.springcloud.bean.Meta;
import com.dpf.springcloud.bean.User;
import com.dpf.springcloud.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;

@Controller
@RequestMapping("auth")
@Slf4j
public class LoginController {

    @Resource
    private LoginService loginService;

    @ResponseBody
    @PostMapping("login")
    public Object login(User user) {
        return new Meta(getToken(user), "ok");
    }

    @ResponseBody
    @GetMapping("menus")
    public Object menu() throws IOException {
        File file = new File(this.getClass().getClassLoader().getResource("menu.json").getFile());
        String menuJsonArr = IOUtils.toString(new FileInputStream(file), Charset.defaultCharset());
        return JSONObject.parseArray(menuJsonArr);
    }

    public String getToken(User user) {
        return JWT.create().withAudience(user.getUsername())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
