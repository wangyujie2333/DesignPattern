package com.design.structure.facade.design;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
@Configuration
@ConditionalOnClass(StartService.class)
@EnableConfigurationProperties(StartServiceProperties.class)
public class StartAutoConfigration {

    private StartServiceProperties startServiceProperties;

    @Bean
    @ConditionalOnMissingBean
    //开启注解参数时启用配置
    @ConditionalOnProperty(prefix = "itstack.door", name = "enable", value = "true")
    public StartService getStartService() {
        return new StartService(startServiceProperties.getUserStr());
    }
}
