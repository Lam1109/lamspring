package com.spring;

public class ApplicationContext {
    private Class configClass;

    public ApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 解析配置类
        // ComponentScan注解-->扫描路径-->扫描
    }

    public Object getBean(String beanName) {
        return null;
    }
}
