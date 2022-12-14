package com.lu.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //解析前端参数
        String language = request.getParameter("l");
        //默认，如果没有就默认的
        Locale locale = Locale.getDefault();
        //请求连接不为空，携带国际化参数
        if(!language.isEmpty()){
            String[] s = language.split("_");
            locale = new Locale(s[0],s[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
