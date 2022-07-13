package quynh.java.sm.langlearning.english.dao.impl;

public class DictionaryDaoImpl {
	private UserDaoImpl userDAO = new UserDaoImpl(null);
	
//	public List<WordManage> findWordManagesByKnownState(Connection conn, WordClientDTO wordDto) {
//		List<WordManage> words = new ArrayList<>();
//		PreparedStatement pstm = null;
//		User user = userDAO.findUserById(conn, wordDto.getUserId());
//		try {
//			String sql = "select word_manage.id, known_state, appear_count, dictionary.id, content, phonetic, add_by_user"
//					+ "from dictionary, word_manage " 
//					+ "where word_manage.word_id = dictionary.id "
//					+ "and word_manage.known_state = ? " 
//					+ "and word_manage.user_id = ?;";
//			pstm = conn.prepareStatement(sql);
//			pstm.setBoolean(1, wordDto.getKnownState());
//			pstm.setInt(2, wordDto.getUserId());
//			ResultSet rs = pstm.executeQuery();
//			while (rs.next()) {
//				WordManage word = new WordManage();
//				word.setId(rs.getInt(1));
//				word.setKnownState(rs.getBoolean(2));
//				word.setAppearCount(rs.getInt(3));
//				word.setWord(new Word(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
//				word.setUser(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				pstm.close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		return words;
//	}
//	public Word findWordDictionaryById(Connection conn, int wordId) {
//		String sql = "select id, content, phonetic, add_by_user from dictionary where id = ?";
//		PreparedStatement pstm = null;
//		Word word = null;
//		try {
//			pstm = conn.prepareStatement(sql);
//			pstm.setInt(1, wordId);
//			ResultSet rs = pstm.executeQuery();
//			if (rs.next())
//			{
//				word = new Word();
//				word.setId(rs.getInt(1));
//				word.setContent(rs.getString(2));
//				word.setPhonetic(rs.getString(3));
//				word.setAddByUser(rs.getBoolean(4));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				pstm.close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		return word;
//	}
//	public Word findWordDictionaryByContent(Connection conn, String content) {
//		String sql = "select id, content, phonetic, add_by_user from dictionary where content = ?";
//		PreparedStatement pstm = null;
//		Word word = null;
//		try {
//			pstm = conn.prepareStatement(sql);
//			pstm.setString(1, content);
//			ResultSet rs = pstm.executeQuery();
//			if (rs.next())
//			{
//				word = new Word();
//				word.setId(rs.getInt(1));
//				word.setContent(rs.getString(2));
//				word.setPhonetic(rs.getString(3));
//				word.setAddByUser(rs.getBoolean(4));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				pstm.close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		return word;
//	}
//	
//	public WordManage findWordManageByWordIdAndUserId(Connection conn, int wordId, int userId) {
//		WordManage word = null;
//		User user = userDAO.findUserById(conn, userId);
//		String sql = "select word_manage.id, known_state, appear_count, dictionary.id, content, phonetic, add_by_user "
//				+ "from dictionary, word_manage " 
//				+ "where word_manage.word_id = dictionary.id "
//				+ "and word_manage.word_id = ?"
//				+ "and word_manage.user_id = ?;";
//		PreparedStatement pstm;
//		try {
//			pstm = conn.prepareStatement(sql);
//			pstm.setInt(1, wordId);
//			pstm.setInt(2, userId);
//			ResultSet rs = pstm.executeQuery();
//			if (rs.next())
//			{
//				word = new WordManage();
//				word.setId(rs.getInt(1));
//				word.setKnownState(rs.getBoolean(2));
//				word.setAppearCount(rs.getInt(3));
//				word.setWord(new Word(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
//				word.setUser(user);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return word;
//	}
//	
//	public int updateWordManageKnownState(Connection conn, boolean knownState, int wordId, int userId) {
//		int result = -1;
//		String sql = "update word_manage set known_state = ? where word_id=? and user_id=?";
//		PreparedStatement pstm;
//		try {
//			pstm = conn.prepareStatement(sql);
//			pstm.setBoolean(1, knownState);
//			result = pstm.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
//	private WordManage addWordManageRel (Connection conn, int wordId, boolean knownState, int appearCount, int userId) {
//		
//		WordManage wordManageCheck = findWordManageByWordIdAndUserId(conn, wordId, userId);
//		
//		if (wordManageCheck == null) {
//			String sql = "insert into word_manage (word_id, known_state, appear_count, user_id) values (?, ?, ?, ?);";
//			PreparedStatement pstm;
//			try {
//				pstm = conn.prepareStatement(sql);
//				pstm.setInt(1, wordId);
//				pstm.setBoolean(2, knownState);
//				pstm.setInt(3, appearCount);
//				pstm.setInt(4, userId);
//				int result = pstm.executeUpdate();
//				if (result == 1) 
//					newWordManage = findWordManageByWordIdAndUserId(conn, wordId, userId));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			if (wordManageCheck.getKnownState() != wordDto.getKnownState()) {
//				int resultUpdate = updateWordManageKnownState(conn, wordDto.getKnownState(), wordId, wordDto.getUserId());
//				if (resultUpdate == 1) {
//					newWordManage = findWordManageByWordIdAndUserId(conn, wordId, wordDto.getUserId());
//				}
//			}
//		}
//		
//		return newWordManage;
//	}
// 	public Word addWordToDictionary(Connection conn, String content) {
//		Word word = null;
//		String sql = "insert into dictionary (content, add_by_user) values (?, true);";
//		PreparedStatement pstm;
//		try {
//			pstm = conn.prepareStatement(sql);
//			pstm.setString(1, content);
//			int result = pstm.executeUpdate();
//			if (result == 1) {
//				word = findWordDictionaryByContent(conn, content);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return word;
//	}
//	
//	public int updateWordManageAppearCount(Connection conn, int wordId, int appearCount, int userId) {
//		int result = -1;
//		String sql = "update word_manage set appear_count = appear_count + ? where word_id=? and user_id=?";
//		PreparedStatement pstm;
//		try {
//			pstm = conn.prepareStatement(sql);
//			pstm.setInt(1, appearCount);
//			pstm.setInt(2, wordId);
//			pstm.setInt(3, userId);
//			result = pstm.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;	
//	}
}
