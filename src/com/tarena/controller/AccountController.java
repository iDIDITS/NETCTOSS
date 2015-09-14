package com.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.dao.AccountDao;
import com.tarena.entity.Account;
import com.tarena.entity.page.AccountPage;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Resource
	private AccountDao accDao;
	
	@RequestMapping("/findAccount.do")
	public String find(AccountPage page , Model model) {
		//��ѯ����ǰҳ������
		List<Account> list = accDao.findByPage(page);
		model.addAttribute("accounts", list);
		
		//��ѯ�����������Ӷ��������ҳ��
		page.setRows(accDao.findRows(page));
		model.addAttribute("accountPage", page);
		return "account/account_list";
	}

}