package com.sc.gateway.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class UrlUtil {

    public static boolean checkUrl(String[] patternPaths,String requestPath){
        for(String patternPath:patternPaths){
            boolean match = match(patternPath, requestPath);
            if(match){
                return true;
            }
        }
        return false;
    }

    public static boolean match(String patternPath, String requestPath) {
        if (StringUtils.isEmpty(patternPath) || StringUtils.isEmpty(requestPath)) {
            return false;
        }
        PathMatcher matcher = new AntPathMatcher();
        return matcher.match(patternPath, requestPath);
    }
}
