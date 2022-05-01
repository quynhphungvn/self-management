package qyn.javaweb.ss.note.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.note.model.NoteType;
import qyn.javaweb.ss.util.DBSupport;

public class NoteTypeDAO {
	public static List<NoteType> getAllNoteType() {
		Connection conn = null;
		List <NoteType> listNoteType = new ArrayList<NoteType>();
		String sql = "select * from note_type";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				NoteType noteType = new NoteType();
				noteType.setNoteTypeId(rs.getInt(1));
				noteType.setNoteTypeType(rs.getString(2));
				listNoteType.add(noteType);
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
		return listNoteType;
	}
	public static NoteType getNoteTypeById(int noteTypeId) {
		Connection conn = null;
		NoteType noteType = null;
		String sql = "select * from note_type where id=" + noteTypeId + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				noteType = new NoteType();
				noteType.setNoteTypeId(rs.getInt(1));
				noteType.setNoteTypeType(rs.getString(2));
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
		return noteType;
	}
}
