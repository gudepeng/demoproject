package com.sc.common.feign;


import com.sc.common.feign.interceptor.ControllerHodler;
import com.sc.common.feign.interceptor.HeaderRequestInterceeptor;
import org.springframework.context.annotation.Bean;

public class ScCommonFeignAutoConfig {

  @Bean
  public ControllerHodler controllerHodler() {
    return new ControllerHodler();
  }

  @Bean
  public HeaderRequestInterceeptor headerRequestInterceeptor() {
    return new HeaderRequestInterceeptor();
  }
}
