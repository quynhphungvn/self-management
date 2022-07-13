package quynh.java.sm.langlearning.english.dao;

import java.util.List;

import quynh.java.sm.langlearning.english.model.Symbol;

public interface SymbolDao {
	public abstract List<Symbol> findAll();
	public abstract Symbol find(int id);
}
