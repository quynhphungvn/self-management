package qyn.javaweb.ss.englearn.ipa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.englearn.ipa.model.IPASymbol;
import qyn.javaweb.ss.util.DBSupport;

public class IPASymbolDAO {
	public static List<IPASymbol> getAllIPASymbol() {
		Connection conn = null;
		List<IPASymbol> listIPASymbol = new ArrayList<IPASymbol>();
		try {
			conn = DBSupport.getMySQLConnection();
			String sql = "select * from ipa_symbol";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				IPASymbol symbol = new IPASymbol();
				symbol.setId(rs.getInt(1));
				symbol.setSymbol(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));
				symbol.setImgGuideLink(rs.getString(5));
				symbol.setVideoGuideLink(rs.getString(6));
				symbol.setIpaType(rs.getString(7));
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
			conn = DBSupport.getMySQLConnection();
			String sql = "select * from ipa_symbol where id=" + id + ";";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				symbol.setId(rs.getInt(1));
				symbol.setSymbol(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));
				symbol.setImgGuideLink(rs.getString(5));
				symbol.setVideoGuideLink(rs.getString(6));
				symbol.setIpaType(rs.getString(7));
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
		return symbol;
	}
}
