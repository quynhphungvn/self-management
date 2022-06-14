package quynh.java.sm.langlearning.english.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.model.Symbol;
import quynh.java.sm.support.db.util.JDBCConnect;

public class SymbolDAO {
	public List<Symbol> getAllSymbol(int userId) {
		Connection conn = null;
		List<Symbol> listIPASymbol = new ArrayList<Symbol>();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select * from symbol;";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Symbol symbol = new Symbol();
				symbol.setId(rs.getInt(1));
				symbol.setSymbol(rs.getString(2));
				symbol.setExample(rs.getString(3));
				symbol.setExamplePhonetic(rs.getString(4));
				symbol.setImgGuideURL(rs.getString(5));
				symbol.setVideoGuideURL(rs.getString(6));
				symbol.setType(rs.getString(7));
				symbol.setUserId(userId);
				String sqlViewCount = "select view_count from symbol_view_info where user_id=? and symbol_id=?";
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
	public Symbol getSymbolById(int userId, int symbolId) {
		Connection conn = null;
		Symbol symbol = new Symbol();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select id, symbol, example, example_phonetic, video_guide_url, image_guide_url, type from symbol where id=?";
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
				symbol.setType(rs.getString(7));
				symbol.setUserId(userId);
				String sqlViewCount = "select view_count from symbol_view_info where user_id=? and symbol_id=?;";
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
	public void updateViewCountSymbol(int userId, int symbolId) {
		Connection conn = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sqlCheckExist = "select * from symbol_view_info where user_id=? and symbol_id=?";
			PreparedStatement pstmCheck = conn.prepareStatement(sqlCheckExist);
			pstmCheck.setInt(1, userId);
			pstmCheck.setInt(2, symbolId);
			ResultSet rsCheck = pstmCheck.executeQuery();
			if (!rsCheck.next()) {
				String sqlInsertNew = "insert into symbol_view_info(user_id, symbol_id, view_count) values (?,?,?)";
				PreparedStatement pstmInsertNew = conn.prepareStatement(sqlInsertNew);
				pstmInsertNew.setInt(1, userId);
				pstmInsertNew.setInt(2, symbolId);
				pstmInsertNew.setInt(3, 1);
				pstmInsertNew.executeUpdate();
				pstmInsertNew.close();
			}
			else {
				String sql = "update symbol_view_info set view_count = view_count + 1 where user_id = ? and symbol_id = ?";
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
