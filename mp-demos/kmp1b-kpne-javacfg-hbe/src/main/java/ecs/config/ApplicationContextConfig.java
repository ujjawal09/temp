package ecs.config;

import static ecs.util.Lgr.ly;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
//Basic implementation of javax.sql.DataSource that is configured via JavaBeans properties
import org.hibernate.SessionFactory;
//The main contract here is the creation of Session instances. Usually an application has a single SessionFactory instance and threads servicing client requests obtain Session instances from this factory.
import org.springframework.beans.factory.annotation.Autowired;
//Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
//This transaction manager is appropriate for applications that use a single Hibernate SessionFactory for transactional data access
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//FactoryBean that creates a Hibernate SessionFactory. This is the usual way to set up a shared Hibernate SessionFactory in a Spring application context; the SessionFactory can then be passed to Hibernate-based data access objects via dependency injection.
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ecs.model.Product;

/*This class will contain the application-context for the application. 
 * Define the following annotations:
 * @Configuration - Annotating a class with the @Configuration indicates that the 
 *                  class can be used by the Spring IoC container as a source of 
 *                  bean definitions
 * @EnableTransactionManagement - Enables Spring's annotation-driven transaction management capability.
 *                  
 * */

@Configuration
//@ComponentScan(basePackages= {"ecs"}, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@EnableTransactionManagement
public class ApplicationContextConfig {

	/*
	 * Define the bean for DataSource. In our application, we are using MySQL as the
	 * dataSource. To create the DataSource bean, we need to know: 1. Driver class
	 * name 2. Database URL 3. UserName 4. Password
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		String dbURL = "jdbc:mysql://" + System.getenv("MYSQL_HOST") + ":3306/" + System.getenv("MYSQL_DATABASE")
				+ "?verifyServerCertificate=false&useSSL=false&requireSSL=false";
		ly(dbURL);
		dataSource.setUrl(dbURL);
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");

		return dataSource;
	}

	/*
	 * Use this configuration while submitting solution in hobbes.
	 * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://" + System.getenv("MYSQL_HOST") + ":3306/" +
	 * System.getenv("MYSQL_DATABASE")
	 * +"?verifyServerCertificate=false&useSSL=false&requireSSL=false");
	 * dataSource.setUsername(System.getenv("MYSQL_USER"));
	 * dataSource.setPassword(System.getenv("MYSQL_PASSWORD"));
	 */

	/*
	 * Define the bean for SessionFactory. Hibernate SessionFactory is the factory
	 * class through which we get sessions and perform database operations.
	 */
	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setHibernateProperties(hibernateProperties());
		ly("factoryBean.setDataSource(dataSource);");
		factoryBean.setDataSource(dataSource);
		factoryBean.setAnnotatedClasses(Product.class);
		return factoryBean;
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return hibernateProperties;
	}

	/*
	 * Define the bean for Transaction Manager. HibernateTransactionManager handles
	 * transaction in Spring. The application that uses single hibernate session
	 * factory for database transaction has good choice to use
	 * HibernateTransactionManager. HibernateTransactionManager can work with plain
	 * JDBC too. HibernateTransactionManager allows bulk update and bulk insert and
	 * ensures data integrity.
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernatetransactionmanager = new HibernateTransactionManager();
		hibernatetransactionmanager.setSessionFactory(sessionFactory);
		return hibernatetransactionmanager;

	}
}
