package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dto.SymbolDto;
import quynh.java.sm.langlearning.english.model.Symbol;

public interface SymbolService {

	List<Symbol> getSymbols();

	SymbolDto getSymbol(int symbolId, int userId);

}
