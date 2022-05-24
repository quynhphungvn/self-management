package qyn.javaweb.ss.note.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.note.model.Priority;
import qyn.javaweb.ss.util.DBSupport;

public class PriorityDAO {
	public static List<Priority> getAllPriority() {
		Connection conn = null;
		List <Priority> listPriority = new ArrayList<Priority>();
		String sql = "select * from priority";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Priority priority = new Priority();
				priority.setPriorityId(rs.getInt(1));
				priority.setPriorityLevel(rs.getString(2));
				priority.setPriorityColor(rs.getString(3));
				listPriority.add(priority);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listPriority;
	}
	public static Priority getPriorityById(int priorityId) {
		Connection conn = null;
		Priority priority = null;
		String sql = "select * from priority where id=" + priorityId + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				priority = new Priority();
				priority.setPriorityId(rs.getInt(1));
				priority.setPriorityLevel(rs.getString(2));
				priority.setPriorityColor(rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return priority;
	}
}
