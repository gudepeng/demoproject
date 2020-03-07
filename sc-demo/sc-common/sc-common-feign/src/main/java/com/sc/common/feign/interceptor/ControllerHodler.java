package com.sc.common.feign.interceptor;

import com.sc.common.base.constant.Constant;
import com.sc.common.base.support.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author ：我是金角大王
 * @date ：Created in 2020/2/28 9:28 下午
 */
@ControllerAdvice
public class ControllerHodler implements ResponseBodyAdvice {

  @Override
  public boolean supports(MethodParameter methodParameter, Class aClass) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType,
      Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    if (object instanceof ApiResponse) {
      return object;
    }
    if (Constant.CALLSOURCESERVICE
        .equals(serverHttpRequest.getHeaders().get(Constant.CALLSOURCE))) {
      return new ApiResponse(object);
    }
    return object;
  }
}
