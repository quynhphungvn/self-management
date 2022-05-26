package quynh.java.sm.langlearning.english.ipa.service;

import java.util.List;

import quynh.java.sm.langlearning.english.ipa.dao.IPASymbolDAO;
import quynh.java.sm.langlearning.english.ipa.dto.IPASymbolDTO;
import quynh.java.sm.langlearning.english.ipa.mapper.IPAMapper;
import quynh.java.sm.langlearning.english.ipa.model.IPASymbol;

public class IPASymbolService {
	private IPASymbolDAO ipaSymbolDAO;
	private IPAMapper ipaMapper;
	public IPASymbolService() {
		ipaSymbolDAO = new IPASymbolDAO();
		ipaMapper = new IPAMapper();
	}
	public List<IPASymbol> getAllIPASymbolByUser(int userId) {
		return ipaSymbolDAO.getAllIPASymbol(userId);
	}
	public IPASymbolDTO getIPASymbolDTOBySymbolId(int userId, int symbolId) {
		ipaSymbolDAO.updateViewCountIPASymbol(userId, symbolId);
		return ipaMapper.convertIPASymbolToIPASymbolDTO(ipaSymbolDAO.getIpaSymbolById(userId, symbolId));
	}
}
