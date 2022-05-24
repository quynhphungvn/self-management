package quynh.java.sm.langlearning.english.ipa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.ipa.model.IPASymbol;
import quynh.java.sm.support.db.util.JDBCConnect;

public class IPASymbolDAO {
	public static List<IPASymbol> getAllIPASymbol() {
		Connection conn = null;
		List<IPASymbol> listIPASymbol = new ArrayList<IPASymbol>();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select * from ipa_symbol";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				IPASymbol symbol = new IPASymbol();
				symbol.setId(rs.getInt(1));
				symbol.setSymbol(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));
				symbol.setImgGuideURL(rs.getString(5));
				symbol.setVideoGuideURL(rs.getString(6));
				symbol.setIpaType(rs.getString(7));
				symbol.setViewCount(rs.getInt(8));
				listIPASymbol.add(symbol);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listIPASymbol;
	}
	public static IPASymbol getById(int id) {
		Connection conn = null;
		IPASymbol symbol = new IPASymbol();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select * from ipa_symbol where id=?;";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery(sql);
			if (rs.next()) {
				symbol.setId(rs.getInt(1));
				symbol.setSymbol(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));
				symbol.setImgGuideURL(rs.getString(5));
				symbol.setVideoGuideURL(rs.getString(6));
				symbol.setIpaType(rs.getString(7));
				symbol.setViewCount(rs.getInt(8));
			}
			pstm.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return symbol;
	}
}
