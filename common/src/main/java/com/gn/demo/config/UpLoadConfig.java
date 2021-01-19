package com.gn.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: gn
 * @Date: 2020-12-15
 * @Description:
 */
@Configuration
public class UpLoadConfig {
    /**
     * 文件上传配置
     *
     * @return
     */
    /*@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("10240KB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }*/
}
