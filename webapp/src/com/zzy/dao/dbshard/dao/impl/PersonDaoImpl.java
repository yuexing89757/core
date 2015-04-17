package com.zzy.dao.dbshard.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.zzy.dao.dbshard.dao.PersonDao;
import com.zzy.dao.impl.hibernate.GenericHbmDAO;
import com.zzy.enums.GetShardType;
import com.zzy.model.shard.Person;

public class PersonDaoImpl extends GenericHbmDAO<Person, Long> implements PersonDao{

	public PersonDaoImpl(Long i, GetShardType advertiser) {
		super(i, advertiser);
	}

	public List<Person> getall() {
		Query query =this.getShardSession().createSQLQuery("select * from person");
		List<Person>  lt= query.list();
		return lt;
	}

}
