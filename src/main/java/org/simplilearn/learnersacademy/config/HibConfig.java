package org.simplilearn.learnersacademy.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.simplilearn.learnersacademy.entities.EClass;
import org.simplilearn.learnersacademy.entities.Student;
import org.simplilearn.learnersacademy.entities.Subject;
import org.simplilearn.learnersacademy.entities.Teacher;
import org.simplilearn.learnersacademy.entities.User;


public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		Properties properties=new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/practice");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(EClass.class);
        configuration.addAnnotatedClass(Subject.class);
		SessionFactory factory=configuration.buildSessionFactory();
		return factory;
	}
}
