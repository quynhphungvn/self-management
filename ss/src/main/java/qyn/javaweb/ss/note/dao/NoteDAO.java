package qyn.javaweb.ss.note.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.note.dto.NoteClientDTO;
import qyn.javaweb.ss.note.model.Note;
import qyn.javaweb.ss.util.DBSupport;
import qyn.javaweb.ss.util.Status;
import qyn.javaweb.ss.util.SSMessage;

public class NoteDAO {
	
	public static List<Note> getAllNote() {
		Connection conn = null;
		List <Note> listNote = new ArrayList<Note>();
		String sql = "select * from note";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Note note = new Note();
				note.setNoteId(rs.getInt(1));
				note.setNoteContent(rs.getString(2));
				note.setNoteComment(rs.getString(3));
				note.setNoteTimeAdded(rs.getDate(4));
				note.setNotePriority(PriorityDAO.getPriorityById(rs.getInt(5)));
				note.setNoteType(NoteTypeDAO.getNoteTypeById(rs.getInt(6)));
				listNote.add(note);				
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
		return listNote;
	}
	public static Status addNote(NoteClientDTO noteClientDTO) {
		Connection conn = null;
		String sql = "insert into note (content, comment, time_add, priority_id, note_type_id) values ('" 
				+ noteClientDTO.getNoteContent() + "', '" + noteClientDTO.getNoteComment() + "', '" 
				+ noteClientDTO.getNoteTimeAdded() + "', " + noteClientDTO.getNotePriorityId() + "," + noteClientDTO.getNoteTypeId() +");";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			return Status.ADD_FAIL;
		} catch (SQLException e) {
			return Status.ADD_FAIL;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return Status.ADD_SUCCESS;
	}
	public static Status deleteNoteById(int id) {
		Connection conn = null;
		String sql = "delete from note where id=\"" + id + "\";";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			return Status.DELETE_FAIL;
		} catch (SQLException e) {
			return Status.DELETE_FAIL;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return Status.DELETE_SUCCESS;
	}
}
