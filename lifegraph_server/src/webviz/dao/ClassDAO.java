package webviz.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ClassDAO<T> implements InterfaceDAO<T>{
	
	private HibernateTemplate hibernateTemplate;
	public HashMap<Class<T>, String> hashMap;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList() {
		return hibernateTemplate.find("from "+hashMap.get(getClass()));
	}


}
