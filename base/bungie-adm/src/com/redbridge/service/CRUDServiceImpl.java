package com.redbridge.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redbridge.dao.CRUDDao;

@Service
public class CRUDServiceImpl implements CRUDService, Serializable {

	@Autowired
	private CRUDDao CRUDDao;

	@Transactional(readOnly = true)
	public <T> List<T> getAll(Class<T> klass) {
		return CRUDDao.getAll(klass);
	}

	@Transactional
	public <T> void Save(T klass) {
		CRUDDao.Save(klass);
	}

	@Transactional
	public <T> void delete(T klass) {
		CRUDDao.delete(klass);
	}

	@Transactional
	public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {
		return CRUDDao.GetUniqueEntityByNamedQuery(query, params);
	}

	public void setCRUDDao(CRUDDao cRUDDao) {
		CRUDDao = cRUDDao;
	}
	
	
}
