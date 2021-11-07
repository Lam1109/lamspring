package com.spring;

import com.lam.Component;
import com.lam.ComponentScan;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

public class ApplicationContext {
    private Class configClass;

    public ApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 解析配置类
        // ComponentScan注解-->扫描路径-->扫描

        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value(); // 扫描路径 com.lam.service
        path = path.replace(".", "/"); //"com/lam/service"
        // 扫描
        ClassLoader classLoader = ApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {
                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                    className = className.replace("\\", ".");

                    try {
                        Class<?> clazz = classLoader.loadClass(className);
                        if (clazz.isAnnotationPresent(Component.class)) {

                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public Object getBean(String beanName) {
        return null;
    }
}
