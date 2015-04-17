package com.zzy.test;

import org.junit.Test;

import com.zzy.biz.shard.IPersonBiz;
import com.zzy.biz.shard.impl.PersonBizImpl;
import com.zzy.dao.ShardInfoDao;
import com.zzy.dao.impl.ShardInfoDaoImpl;
import com.zzy.model.ShardInfo;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ShardInfoDao sd=new ShardInfoDaoImpl();
		//ShardInfo sdf=sd.findByAdId(-1l);
		//System.out.println(sdf.getDataBaseName());
		
		
	
	}
	
	@Test
	public void  get(){
		IPersonBiz  ib=new PersonBizImpl();
		ib.getall();
	}

}
