package com.sc.common.feign.interceptor;

import com.sc.common.base.constant.Constant;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author ：我是金角大王
 * @date ：Created in 2020/2/28 9:21 下午
 */
public class HeaderRequestInterceeptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(Constant.CALLSOURCE, Constant.CALLSOURCESERVICE);
    }
}
