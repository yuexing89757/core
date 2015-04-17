package com.zzy.dao.dbshard.dao;

import java.util.List;

import com.zzy.dao.impl.hibernate.GenericDAO;
import com.zzy.model.shard.Person;

public interface PersonDao extends GenericDAO<Person, Long>{
	
     public List<Person> getall();
}
