package com.care.root.Ser;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.dao.MDao;
import com.care.root.dto.MDto;

@Service
public class MService {
	
	@Autowired MDao dao;
	
	public MService() {
		System.out.println("ser");
	}
	
	public void register(MDto dto) {
		dao.register(dto);
	}
	
	public int loginChk(String id, String pwd) {
		int result = dao.loginChk(id, pwd);
		System.out.println("ser loginchk : " + result);
		return result;
	}
	
	public ArrayList<MDto> list() {
		ArrayList<MDto> dto = dao.list();
		return dto;
	}
	
	public MDto getInfo(String id) {
		MDto dto = dao.getInfo(id);
		return dto;
	}
	
}
