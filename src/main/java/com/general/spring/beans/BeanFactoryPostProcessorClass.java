package com.general.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorClass implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("Inside bean factory post process");
        for (String beanNames : configurableListableBeanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanNames);
            if (beanDefinition.getBeanClassName().equals(BeanFactoryPostProcessorClass.class.getName())) {
                System.out.println(beanDefinition.getScope());
                beanDefinition.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);
            }
            System.out.println(beanDefinition);
        }
    }
}
