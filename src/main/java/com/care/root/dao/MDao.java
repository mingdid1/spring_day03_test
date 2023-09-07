package com.care.root.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.root.dto.MDto;

@Repository
public class MDao {
	
	
	ArrayList<MDto> DB;
	public MDao() {
		// DB = ArrayList 생성 꼭 해주기!!
		DB = new ArrayList<MDto>();
		System.out.println("dao");
	}
	
	public void register(MDto dto) {
		MDto d = new MDto();
		
		d.setId(dto.getId());
		d.setPwd(dto.getPwd());
		d.setName(dto.getName());
		
		DB.add(d);
		System.out.println("dao reg: "+ DB.size());
	}
	
	public ArrayList<MDto> list() {
		System.out.println("dao list");
		ArrayList<MDto> dto = new ArrayList<MDto>();
		
		for(int i = 0; i<DB.size(); i++) {
			MDto d = new MDto();
			d.setId(DB.get(i).getId());
			d.setPwd(DB.get(i).getPwd());
			d.setName(DB.get(i).getName());
			dto.add(d);
		}
		return dto;
	}
	
	public int loginChk(String id, String pwd) {
		int result = 0;
		
		for(int i = 0; i<DB.size(); i++) {
			if(id.equals(DB.get(i).getId()) && pwd.equals(DB.get(i).getPwd())) {
				result = 1;
			}
		}
		return result;
	}

	public MDto getInfo(String id) {
		MDto dto = new MDto();
		
		for(int i=0; i<DB.size(); i++) {
			if(id.equals(DB.get(i).getId())) {
				dto.setId(DB.get(i).getId());
				dto.setPwd(DB.get(i).getPwd());
				dto.setName(DB.get(i).getName());
			}
		}
		return dto;
	}
	
}
