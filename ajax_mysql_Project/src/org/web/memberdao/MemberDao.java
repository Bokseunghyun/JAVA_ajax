package org.web.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.web.dbconnect.Dbconnect;
import org.web.memberdto.MemberDto;

public class MemberDao {
	
	private MemberDao() {}
	
	private static class singleton {
		
		private static final MemberDao INSTANCE = new MemberDao();
	}
	public static MemberDao getInstance() {
	
		return singleton.INSTANCE;
	}
	
	//아이디 체크
	public int idChecked(String userId) {
		int result = 0;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query="";
		conn=Dbconnect.getConnection();
		query="select count(*) from ajax1 where userId=?";
		try {
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);
			rs = pstm.executeQuery();
			while(rs.next())
			{
				result=rs.getInt(1);
			}
		} 
		catch (Exception e) {
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {}
		}
		return result;
	}
	public int insert(String userId, String userPw, String userName, String userAddr) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = Dbconnect.getConnection();
			query = "insert into ajax1 values(?,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setString(4, userAddr);

			result = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}

		}
		return result;

	}

	public int login(String userId,String userPw) {
		int result = 0;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		conn=Dbconnect.getConnection();
		String query="";
		query="select count(*) from ajax1 where userId=? and userPw=?";
		try {
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			rs = pstm.executeQuery();
			while(rs.next())
			{
				result=rs.getInt(1);
			}
		} 
		catch (Exception e) {
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public int delete(String userId,String userPw) {
		int result = 0;
		Connection conn= null;
		PreparedStatement pstm = null;
		conn=Dbconnect.getConnection();
		String query="";
		query="delete from ajax1 where userId=? and userPw=?";
		try {
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			result = pstm.executeUpdate();
		} 
		catch (Exception e) {
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public MemberDto memberView(String userId) {
		MemberDto dto = null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		conn=Dbconnect.getConnection();
		String query="";
		query="select * from ajax1 where userId=?";
		try {
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);
			rs = pstm.executeQuery();
			while(rs.next())
			{
				dto = new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} 
		catch (Exception e) {
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public int update(String userId, String userPw, String userName, String userAddr) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = Dbconnect.getConnection();
			query = "update ajax1 set userPw=?,userName=?,userAddr=? where userId=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, userPw);
			pstm.setString(2, userName);
			pstm.setString(3, userAddr);
			pstm.setString(4, userId);

			result = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}

		}
		return result;

	}
	
	public ArrayList<MemberDto> memberList() {
		ArrayList<MemberDto> dto = new ArrayList<MemberDto>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		conn=Dbconnect.getConnection();
		String query="";
		query="select * from ajax1";
		try {
			pstm=conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				dto.add(new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} 
		catch (Exception e) {
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public ArrayList<MemberDto> SearchList(String search) {
		ArrayList<MemberDto> dto = new ArrayList<MemberDto>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		conn=Dbconnect.getConnection();
		String query="";
		query="select * from ajax1 where userId like ?";
		try {
			pstm=conn.prepareStatement(query);
			pstm.setString(1, "%"+search+"%");
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				dto.add(new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} 
		catch (Exception e) {
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}
