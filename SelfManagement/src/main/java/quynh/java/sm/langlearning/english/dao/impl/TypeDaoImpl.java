package quynh.java.sm.langlearning.english.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import quynh.java.sm.langlearning.english.dao.TypeDao;
import quynh.java.sm.langlearning.english.model.Type;
import quynh.java.sm.langlearning.english.model.User;

public class TypeDaoImpl implements TypeDao{
	private Connection conn;
	
	public TypeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<Type> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type find(int typeId) {
		String sql = "select id, name from type where id = ?";
		PreparedStatement pstm = null;
		Type type = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, typeId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				type = new Type();
				type.setId(rs.getInt(1));
				type.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				pstm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return type;
	}

	@Override
	public Type find(String typeName) {
		String sql = "select id, name from type where name = ?";
		PreparedStatement pstm = null;
		Type type = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, typeName);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				type = new Type();
				type.setId(rs.getInt(1));
				type.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				pstm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return type;
	}

	@Override
	public int add(Type type) {
		int result = 0;
		String sql = "insert into type(name) values (?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, type.getName());
			result = pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				pstm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}

}
