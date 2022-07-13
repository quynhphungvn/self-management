package quynh.java.sm.langlearning.english.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quynh.java.sm.langlearning.english.dao.SymbolLearningDao;
import quynh.java.sm.langlearning.english.dao.SymbolDao;
import quynh.java.sm.langlearning.english.dao.UserDao;
import quynh.java.sm.langlearning.english.model.SymbolLearning;

public class SymbolLearningDaoImpl implements SymbolLearningDao {
	private Connection conn;
	private SymbolDao symbolDao;
	private UserDao userDao;
	
	public SymbolLearningDaoImpl(Connection conn) {
		this.conn = conn;
		symbolDao = new SymbolDaoImpl(conn);
		userDao = new UserDaoImpl(conn);
	}
	@Override
	public SymbolLearning find(int symbolId, int userId) {
		SymbolLearning symbolManage = null;
		String sql = "select id, view_count from symbol_learning where symbol_id=? and user_id=?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, symbolId);
			pstm.setInt(2, userId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				symbolManage = new SymbolLearning();
				symbolManage.setId(rs.getInt(1));
				symbolManage.setViewCount(rs.getInt(2));
				symbolManage.setSymbol(symbolDao.find(symbolId));
				symbolManage.setUser(userDao.find(userId));
			}
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		return symbolManage;
	}
	public int updateViewCount(int symbolId, int userId) {
		int result = 0;
		String sql = "update symbol_learning set view_count = view_count + 1 where symbol_id = ? and user_id = ?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, symbolId);
			pstm.setInt(2, userId);
			result = pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public int add(int symbolId, int userId, int viewCount) {
		int result = 0;
		String sql = "insert into symbol_learning(symbol_id, user_id, view_count) values (?, ?, ?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, symbolId);
			pstm.setInt(2, userId);
			pstm.setInt(3, viewCount);
			result = pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
