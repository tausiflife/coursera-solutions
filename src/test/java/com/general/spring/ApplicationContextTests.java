package com.general.spring;

import com.general.spring.beans.*;
import com.general.spring.config.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.time.LocalDateTime;


public class ApplicationContextTests {
    private ApplicationContext applicationContext;


    @Test
    public void testApplicationContextCreation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SpringService springService = applicationContext.getBean(SpringService.class);
        Assertions.assertNotNull(springService);
        springService.serve();
        ((AbstractApplicationContext)applicationContext).close();
    }
    @Test
    public void getBeanWithAlias() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigurationWithBeanParameters.class);
        SpringService springService = applicationContext.getBean(SpringService.class);
        Assertions.assertNotNull(springService);
        springService.serve();
        ((AbstractApplicationContext)applicationContext).close();
    }

    @Test
    public void testCircularDependencyTest() {
        Assertions.assertThrows(UnsatisfiedDependencyException.class, () -> {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigurationWithCircularDependency.class);
        });
    }

    @Test
    public void testCircularDependencyResolved() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                CircularDependencyResolvedClassA.class, CircularDependencyResolvedClassB.class);
        Assertions.assertNotNull(applicationContext);
        CircularDependencyResolvedClassA classA = applicationContext.getBean(CircularDependencyResolvedClassA.class);
        Assertions.assertNotNull(classA);
        CircularDependencyResolvedClassB classB = applicationContext.getBean(CircularDependencyResolvedClassB.class);
        Assertions.assertNotNull(classB);
        Assertions.assertNotNull(classB.getDependencyResolvedClassA());
        ((AbstractApplicationContext)applicationContext).close();
    }

    @Test
    public void testBeansInjectionWithDifferentScope() throws InterruptedException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationForBeansOfDifferentScope.class);
        SingletonBean singletonBean = applicationContext.getBean(SingletonBean.class);
        LocalDateTime dateTime = singletonBean.getDateTime();
        Thread.sleep(1000);

        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        LocalDateTime dateTime1 = singletonBean1.getDateTime();

        Assert.assertTrue(dateTime1.isAfter(dateTime));
        ((ConfigurableApplicationContext)applicationContext).close();
    }

    @Test
    public void testSpringCallbacks() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigurationWithCallback.class);
        SpringBeanCallbacks springBeanCallbacks = applicationContext.getBean(SpringBeanCallbacks.class);
        ((ConfigurableApplicationContext)applicationContext).close();
    }

    @Test
    void testBeanNameAwareClass() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBeanNameAwareConfig.class);
        BeanNameAwareClass beanNameAwareClass = applicationContext.getBean(BeanNameAwareClass.class);
        ((ConfigurableApplicationContext)applicationContext).close();
    }

    @Test
    void testSpringBeanPostProcessor() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanPostProcessorClass.class);
        BeanPostProcessorClass beanPostProcessorClass = applicationContext.getBean(BeanPostProcessorClass.class);
        ((ConfigurableApplicationContext)applicationContext).close();
    }

    @Test
    void testBeanFactoryPostProcessor() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorClass.class);
        BeanFactoryPostProcessorClass beanPostProcessorClass = applicationContext.getBean(BeanFactoryPostProcessorClass.class);
        ((ConfigurableApplicationContext)applicationContext).close();

    }

    @Test
    void testBeanWithMultipleConstructor() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanWithMultipleConstructor.class, PrototypeBean.class);
        BeanWithMultipleConstructor beanPostProcessorClass = applicationContext.getBean(BeanWithMultipleConstructor.class);
        ((ConfigurableApplicationContext)applicationContext).close();
    }

    @Test
    void testBeansWithGenerics() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GenericsAutowiringConfig.class, GenericAutowire.class);
        GenericAutowire genericAutowire = applicationContext.getBean(GenericAutowire.class);
        genericAutowire.testStores();
        ((ConfigurableApplicationContext)applicationContext).close();
    }
}
