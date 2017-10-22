package com.sanya.spring_simple.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sanle on 9/15/2017.
 */
@RestController
public class SimpleController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        StringBuilder userInfoSb = new StringBuilder();
        userInfoSb.append("Local address: ").append(request.getRemoteAddr()).append("; ");
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null) {
            userInfoSb.append("X-Forwarded-For: ").append(ip).append("; ");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            if (ip != null) {
                userInfoSb.append("Proxy-Client-IP: ").append(ip).append("; ");
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            if (ip != null) {
                userInfoSb.append("WL-Proxy-Client-IP: ").append(ip).append("; ");
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            if (ip != null) {
                userInfoSb.append("HTTP_CLIENT_IP: ").append(ip).append("; ");
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            if (ip != null) {
                userInfoSb.append("HTTP_X_FORWARDED_FOR: ").append(ip).append("; ");
            }
        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
        return userInfoSb.toString();
    }
}
