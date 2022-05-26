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
	public List<IPASymbol> getAllIPASymbol(int userId) {
		Connection conn = null;
		List<IPASymbol> listIPASymbol = new ArrayList<IPASymbol>();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select * from ipa_symbol;";
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
				String sqlViewCount = "select view_count from user_ipa_symbol where user_id=? and ipa_symbol_id=?";
				PreparedStatement pstm = conn.prepareStatement(sqlViewCount);
				pstm.setInt(1, 1);
				pstm.setInt(2, 1);
				ResultSet rsViewCount = pstm.executeQuery();
				if (rsViewCount.next())
					symbol.setViewCount(rsViewCount.getInt(1));
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
	public IPASymbol getIpaSymbolById(int userId, int symbolId) {
		Connection conn = null;
		IPASymbol symbol = new IPASymbol();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select id, symbol, example, example_phonetic, video_guide_url, image_guide_url, type from ipa_symbol where id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, symbolId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				symbol.setId(rs.getInt(1));
				symbol.setSymbol(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));		
				symbol.setVideoGuideURL(rs.getString(5));
				symbol.setImgGuideURL(rs.getString(6));
				symbol.setIpaType(rs.getString(7));
				String sqlViewCount = "select view_count from user_ipa_symbol where user_id=? and ipa_symbol_id=?;";
				PreparedStatement pstmViewCount = conn.prepareStatement(sqlViewCount);
				pstmViewCount.setInt(1, userId);
				pstmViewCount.setInt(2, symbolId);
				ResultSet rsViewCount = pstmViewCount.executeQuery();
				if (rsViewCount.next())
					symbol.setViewCount(rsViewCount.getInt(1));
				pstmViewCount.close();
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
	public void updateViewCountIPASymbol(int userId, int symbolId) {
		Connection conn = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sqlCheckExist = "select * from user_ipa_symbol where user_id=? and ipa_symbol_id=?";
			PreparedStatement pstmCheck = conn.prepareStatement(sqlCheckExist);
			pstmCheck.setInt(1, userId);
			pstmCheck.setInt(2, symbolId);
			ResultSet rsCheck = pstmCheck.executeQuery();
			if (!rsCheck.next()) {
				String sqlInsertNew = "insert into user_ipa_symbol(user_id, ipa_symbol_id, view_count) values (?,?,?)";
				PreparedStatement pstmInsertNew = conn.prepareStatement(sqlInsertNew);
				pstmInsertNew.setInt(1, userId);
				pstmInsertNew.setInt(2, symbolId);
				pstmInsertNew.setInt(3, 1);
				pstmInsertNew.executeUpdate();
				pstmInsertNew.close();
			}
			else {
				String sql = "update user_ipa_symbol set view_count = view_count + 1 where user_id = ? and ipa_symbol_id = ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, userId);
				pstm.setInt(2, symbolId);
				pstm.executeUpdate();
				pstm.close();
			}
			pstmCheck.close();
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
	}
}
