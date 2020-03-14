package com.family.oa.service.impl;

import java.util.List;

import com.family.oa.dao.impl.TypesDaoImpl;
import com.family.oa.entity.TypesEntity;
import com.family.oa.service.TypesService;

public class TypesServiceImpl implements TypesService {
	TypesDaoImpl type = new TypesDaoImpl();
	@Override
	public List<TypesEntity> findAll(){
		return type.findAll();
	}
}
