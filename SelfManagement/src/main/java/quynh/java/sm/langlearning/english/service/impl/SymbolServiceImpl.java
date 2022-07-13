package quynh.java.sm.langlearning.english.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import quynh.java.sm.langlearning.english.dao.SymbolDao;
import quynh.java.sm.langlearning.english.dao.SymbolLearningDao;
import quynh.java.sm.langlearning.english.dao.impl.SymbolDaoImpl;
import quynh.java.sm.langlearning.english.dao.impl.SymbolLearningDaoImpl;
import quynh.java.sm.langlearning.english.dto.SymbolDto;
import quynh.java.sm.langlearning.english.mapper.SymbolMapper;
import quynh.java.sm.langlearning.english.model.Symbol;
import quynh.java.sm.langlearning.english.model.SymbolLearning;
import quynh.java.sm.langlearning.english.service.SymbolService;
import quynh.java.sm.support.db.util.JDBCConnect;

public class SymbolServiceImpl implements SymbolService{
	private SymbolDao symbolDao;
	private SymbolLearningDao symbolLearningDao;
	private SymbolMapper symbolMapper;
	private Connection conn;
	
	public SymbolServiceImpl() {
		try {
			conn = JDBCConnect.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		symbolDao = new SymbolDaoImpl(conn);
		symbolMapper = new SymbolMapper();
		symbolLearningDao = new SymbolLearningDaoImpl(conn);
	}
	
	@Override
	public List<Symbol> getSymbols() {
		return symbolDao.findAll();
	}
	
	@Override
	public SymbolDto getSymbol(int symbolId, int userId) {
		SymbolLearning sm = symbolLearningDao.find(symbolId, userId);
		if (sm == null) 
			symbolLearningDao.add(symbolId, userId, 1);
		else
			symbolLearningDao.updateViewCount(symbolId, userId);
		return symbolMapper.convertSymbolLearningToSymbolDTO(symbolLearningDao.find(symbolId, userId));
	}
}
