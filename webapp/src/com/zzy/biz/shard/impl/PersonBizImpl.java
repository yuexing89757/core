package com.zzy.biz.shard.impl;

import java.util.List;

import com.zzy.biz.shard.IPersonBiz;
import com.zzy.dao.dbshard.dao.PersonDao;
import com.zzy.dao.dbshard.dao.impl.PersonDaoImpl;
import com.zzy.dao.dbtool.DaoFactory;
import com.zzy.enums.GetShardType;
import com.zzy.model.shard.Person;

public class PersonBizImpl implements IPersonBiz{

	public List<Person> getall() {
		PersonDao pd=DaoFactory.getInstance(PersonDao.class, GetShardType.ADVERTISER, -1l);
		//PersonDao pd=new PersonDaoImpl(-1l,GetShardType.ADVERTISER);
		List lt=pd.getall();
		System.out.println(lt.size());
		return lt;
	}

}
