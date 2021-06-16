```xml
<web-app>
  <servlet>
    <servlet-name>traditionalServlet</servlet-name>
    <servlet-class>ecs.web.TraditionalServlet</servlet-class>
  </servlet>
  <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>traditionalServlet</servlet-name>
    <url-pattern>/web</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>

```

```java
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationContextConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

```


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:context="http://www.springframework.org/schema/context"
	   xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
 	http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-5.0.xsd
 	http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">

	<!-- add base packages to scan  -->

	<context:component-scan base-package="ecs.*"></context:component-scan>
	<context:annotation-config></context:annotation-config>
	<!--  Define the bean for view resolver so that it can be used to resolve the
	 * JSP files which are existing in /WEB-INF/views folder. A ViewResolver is capable of 
	 * mapping logical view names to actual views, such as a JSP or a HTML page.
	 -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="WEB-INF/views/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>
</beans>
```

```java
@Configuration
@EnableWebMvc
@ComponentScan("ecs")
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalresourceviewresolver = new InternalResourceViewResolver();
		internalresourceviewresolver.setPrefix("/WEB-INF/views/");
		internalresourceviewresolver.setSuffix(".jsp");
		return internalresourceviewresolver;
	}
}
```


