package quynh.java.sm.langlearning.english.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.dao.SymbolDao;
import quynh.java.sm.langlearning.english.dao.TypeDao;
import quynh.java.sm.langlearning.english.model.Symbol;

public class SymbolDaoImpl implements SymbolDao{
	private Connection conn;
	private TypeDao typeDao;
	public SymbolDaoImpl(Connection conn) {
		this.conn = conn;
		this.typeDao = new TypeDaoImpl(conn);
	}
	@Override
	public List<Symbol> findAll() {
		List<Symbol> listSymbol = new ArrayList<Symbol>();
		Statement stm = null;
		try {
			String sql = "select id, content, example, example_phonetic, video_guide_url, image_guide_url, type_id from symbol;";
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Symbol symbol = new Symbol();
				symbol.setId(rs.getInt(1));
				symbol.setContent(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));
				symbol.setImgGuideURL(rs.getString(5));
				symbol.setVideoGuideURL(rs.getString(6));
				symbol.setType(typeDao.find(rs.getInt(7)));
				listSymbol.add(symbol);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				stm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return listSymbol;
	}
	@Override
	public Symbol find(int id) {
		Symbol symbol = null;
		PreparedStatement pstm = null;
		try {
			String sql = "select id, content, example, example_phonetic, video_guide_url, image_guide_url, type_id from symbol where id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				symbol = new Symbol();
				symbol.setId(rs.getInt(1));
				symbol.setContent(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));		
				symbol.setVideoGuideURL(rs.getString(5));
				symbol.setImgGuideURL(rs.getString(6));
				symbol.setType(typeDao.find(rs.getInt(7)));
			}
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		return symbol;
	}
}
