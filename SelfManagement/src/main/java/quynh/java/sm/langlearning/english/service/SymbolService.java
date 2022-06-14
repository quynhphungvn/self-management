package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dao.SymbolDAO;
import quynh.java.sm.langlearning.english.dto.SymbolDTO;
import quynh.java.sm.langlearning.english.mapper.SymbolMapper;
import quynh.java.sm.langlearning.english.model.Symbol;

public class SymbolService {
	private SymbolDAO symbolDAO;
	private SymbolMapper symbolMapper;
	public SymbolService() {
		symbolDAO = new SymbolDAO();
		symbolMapper = new SymbolMapper();
	}
	public List<Symbol> getAllSymbolByUser(int userId) {
		return symbolDAO.getAllSymbol(userId);
	}
	public SymbolDTO getSymbolDTOBySymbolId(int userId, int symbolId) {
		symbolDAO.updateViewCountSymbol(userId, symbolId);
		return symbolMapper.convertSymbolToSymbolDTO(symbolDAO.getSymbolById(userId, symbolId));
	}
}
