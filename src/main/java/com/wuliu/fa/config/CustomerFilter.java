package com.wuliu.fa.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;
/**
 * 伪静态
 * @author Admin
 *
 */
@Configuration
public class CustomerFilter {
/*    @Bean
    public FilterRegistrationBean urlRewrite(){
        UrlRewriteFilter rewriteFilter=new UrlRewriteFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean(rewriteFilter);
        registration.setUrlPatterns(Arrays.asList("/*"));
        Map initParam=new HashMap();
        //initParam.put("confPath","urlrewirte.xml");
       // initParam.put("modRewriteConfText","RewriteRule /(\\w+)_(\\w+)_(\\w+).html  /$1?cfd=$2&ddd=$3 [F]");
        initParam.put("modRewriteConfText","RewriteRule ^/(\\w+)_([\\w\\d]).html$  /$1?xian1=$2 [F]");
        
        //initParam.put("modRewriteConfText","RewriteRule ^/(\\w+)_([\\w\\d]).html$  /?xian2=$1&xian1=$2 [F]");
        //initParam.put("modRewriteConfText","RewriteRule ^/lingdan_(\\w+).html$  /lingdan?xian1=$1 [F]");
        //initParam.put("modRewriteConfText","RewriteRule ^/sh_(\\w+).html$  /sh?xian1=$1 [F]");
        initParam.put("logLevel","DEBUG");
        registration.setInitParameters(initParam);
        return  registration;
    }*/
}