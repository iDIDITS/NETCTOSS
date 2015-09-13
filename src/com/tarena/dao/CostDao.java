package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Cost;
import com.tarena.entity.page.CostPage;

/**
 * Cost���ʷѱ������ݳ־ò�ӿ�
 * 
 * @author Jsong
 *
 */
@MyBatisRepository
public interface CostDao {
	
	public List<Cost> findAll();
	
	public void save(Cost cost);
	
	public Cost findById(int id);
	
	public void update(Cost cost);
	
	public void delete(int id);
	
	public List<Cost> findByPage(CostPage page) ;
	
	public int findRows();

}