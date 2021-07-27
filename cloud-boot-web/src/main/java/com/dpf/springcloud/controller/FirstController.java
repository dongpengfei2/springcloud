package com.dpf.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FirstController {
    @GetMapping(value = "/first")
    public Object first(HttpServletRequest request, HttpServletResponse response){
        Enumeration<String> headerNames = request.getHeaderNames();
        while(true) {
            String s = headerNames.nextElement();
            if (s==null) break;
            System.out.println(s + " : " + request.getHeader(s));
        }
        System.out.println("-------------------------------------------------");
        response.addHeader("connection", "keep-alive");
        for(String headerName : response.getHeaderNames()){
            System.out.println(headerName + " : " + response.getHeader(headerName));
        }
        return "hello world";
    }
    @GetMapping(value = "/login/getGameList")
    public Object getGameInfo(){
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        data.put("id", 0);
        data.put("isNecessary", 1);
        data.put("percent", 99);
        data.put("countryID", -1);
        data.put("platform", "");
        data.put("open", true);
        result.put("code", 0);
        result.put("msg", "success");
        result.put("data", data);
        return result;
    }
    @GetMapping(value = "/login/setGameInfo")
    public Object setGameInfo(Integer id, String isNecessary, String percent, String countryID, String platform, Boolean open){
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "success");
        return result;
    }
}
