#HIBERNATE SETUP
http://sourceforge.net/projects/hibernate/files/hibernate4/4.2.21.Final/hibernate-release-4.2.21.Final.zip/download
download hibernate
hibernate-release-4.2.3.Final

create lib folder and load jar files
all hibernate jars + ojdbc14.jar
jar location: hibernate-release-4.2.3.Final\lib\required

#CONFIGURE HIBERNATE
Plugin : Red Hat Developer Studio 
create hibernate.cfg.xml inside cs10-hibernate-crud/src
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
 <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
  <property name="hibernate.connection.password">hr</property>
  <property name="hibernate.connection.url">jdbc:oracle:thin:@localhost:1521:xe</property>
  <property name="hibernate.connection.username">hr</property>
  <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>
  <property name="hibernate.show_sql">true</property>
  <property name="hibernate.hbm2ddl.auto">create</property>
  <mapping resource="com/domain/model/Product.hbm.xml"/>
    </session-factory>
</hibernate-configuration>

#CREATE THE PRODUCT MODEL
class Product ......

#CREATE THE MAPPING FILE
Product.hbm.xml
<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<!-- Generated Mar 4, 2019 12:33:19 PM by Hibernate Tools 3.5.0.Final -->
<hibernate-mapping>
    <class name="com.domain.model.Product" table="PRODUCTS">
        <id name="productId" type="java.lang.String">
            <column name="PRODUCT_ID" />
            <generator class="assigned" />
        </id>
        <property name="productName" type="java.lang.String">
            <column name="PRODUCT_NAME" />
        </property>
    </class>
</hibernate-mapping>

#ADD JARS FROM LIB TO CLASSPATH
#IMPLEMENT A SINGLETON DESIGN PATTERN TO RETURN SESSIONFACTORY
package com.domain.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilities {
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static {
		try {
			Configuration configuration = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException exception) {
			System.out.println("ERROR : Creating Session Factory!");
			System.out.println(exception);
		}
	}
}

