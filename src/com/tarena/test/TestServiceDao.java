package com.tarena.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.AccountDao;
import com.tarena.dao.ServiceDao;
import com.tarena.entity.Account;
import com.tarena.entity.Service;
import com.tarena.entity.page.ServicePage;

public class TestServiceDao {

//	@Test
	public void testFindByPage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceDao dao = context.getBean(ServiceDao.class);
		ServicePage page = new ServicePage();
		List<Map<String, Object>> list = dao.findByPage(page);
		for (Map<String, Object> map : list) {
			System.out.println(map.get("SERVICE_ID") + " "
		  + map.get("OS_USERNAME") + " "
		  + map.get("UNIX_HOST") + " "
		  + map.get("IDCARD_NO") + " "
		  + map.get("COST_NAME") + " "
		  );
		}
	}
	
//	@Test
	public void testFindByRows(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceDao dao = context.getBean(ServiceDao.class);
		ServicePage page = new ServicePage();
		System.out.println(dao.findRows(page));
	}
	
//	@Test
	public void testPauseService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceDao dao = context.getBean(ServiceDao.class);
		dao.pause(2001);
	}
	
	@Test
	public void testFindById(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceDao dao = context.getBean(ServiceDao.class);
		AccountDao accountDao = context.getBean(AccountDao.class);
		Map<String, Object> service = dao.findById(2001);
		BigDecimal b = (BigDecimal) service.get("ACCOUNT_ID");
		int i = b.intValue();
		System.out.println(i);
//		Integer account_id = Integer.parseInt(service.get("ACCOUNT_ID").toString());
//		Account account = accountDao.findById(account_id);
//		System.out.println(account.getStatus().equals("0"));
	}
	
//	@Test
	public void testUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceDao dao = context.getBean(ServiceDao.class);
		Service service = new Service();
		service.setService_id(2001);
		service.setCost_id(2);
		dao.update(service);
	}
	
}