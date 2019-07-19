package org.web.borddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.web.borddto.BordDto;
import org.web.dbconnect.Dbconnect;


public class BordDao {
	private BordDao() {}
	
	private static class Singleton {
		private static final BordDao INSTANCE = new BordDao();
	}
	public static BordDao getInstance() {
		return Singleton.INSTANCE;
	}
	
	
	public int write(String nickName, String userId, String mPw, String title, String memo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "insert into bord_reply(mGroup,mIndent,step,hit,nickName,userId,mPw,title,memo,mTime)"
					+"values((select case count(*) when 0 then 1 else max(mGroup)+1 end from bord_reply b1),0,0,0,?,?,?,?,?, now())";
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, nickName);
			pstm.setString(2, userId);
			pstm.setString(3, mPw);
			pstm.setString(4, title);
			pstm.setString(5, memo);
			result = pstm.executeUpdate();
		} catch (Exception e) {
		}
		return result;
	}
	
	public ArrayList<BordDto> BordList() {
		ArrayList<BordDto> dto = new ArrayList<BordDto>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "select * from bord_reply order by mGroup desc,step asc";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.add(new BordDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getTimestamp(11)));
			}
		} catch (Exception e) {
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
	
	public BordDto BordView(int mId) {
		upHit(mId);
		BordDto dto = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		conn=Dbconnect.getConnection();
		String query="";
		try {
			
			query = "select * from bord_reply where mId=?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, mId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto = new BordDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getTimestamp(11));
			}
		} catch (Exception e) {
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
	public int upHit(int mId) {
		int result =0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "update bord_reply set hit = hit+1 where mId=?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, mId);
			result = pstm.executeUpdate();
		} catch (Exception e) {
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
	
	public int BordUpdate(String mId,String nickName, String userId, String mPw, String title, String memo,String hit) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "update bord_reply set nickName=?, mPw=?, title=?, memo=?, hit=? where mId=? and userId=?";
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, nickName);
			pstm.setString(2, mPw);
			pstm.setString(3, title);
			pstm.setString(4, memo);
			pstm.setInt(5, Integer.parseInt(hit)-1);
			pstm.setInt(6, Integer.parseInt(mId));
			pstm.setString(7, userId);
			
			result = pstm.executeUpdate();
		} catch (Exception e) {
		}
		return result;
	}
	
	public int BordDelete(String mId,String userId2, String mPw2) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "delete from bord_reply where mId=? and userId=? and mPw=?";
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, Integer.parseInt(mId));
			pstm.setString(2, userId2);
			pstm.setString(3, mPw2);
			
			result = pstm.executeUpdate();
		} catch (Exception e) {
		}
		return result;
	}
	
	public ArrayList<BordDto> mBordList(String userId) {
		ArrayList<BordDto> dto = new ArrayList<BordDto>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "select * from bord_reply where userId=? order by mGroup desc,step asc";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.add(new BordDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getTimestamp(11)));
			}
		} catch (Exception e) {
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
	public int reply(String mId,String nickName, String userId, String mPw, String title, String memo, String mGroup, String step, String mIndent) {
		int result = 0;
		replyUpdate(mGroup,step);
		Connection conn = null;
		PreparedStatement pstm = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "insert into bord_reply(mGroup,mIndent,step,nickName,userId,mPw,memo,title,mTime)"
					+"values(?,?,?,?,?,?,?,?, now())";
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, Integer.parseInt(mGroup));
			pstm.setInt(2, Integer.parseInt(mIndent)+1);
			pstm.setInt(3, Integer.parseInt(step)+1);
			pstm.setString(4, nickName);
			pstm.setString(5, userId);
			pstm.setString(6, mPw);
			pstm.setString(7, memo);
			pstm.setString(8, title);
			result = pstm.executeUpdate();
		} catch (Exception e) {
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
	
	public BordDto replyView(int mId) {
		upHit(mId);
		BordDto dto = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		conn = Dbconnect.getConnection();
		String query = "";
		try {
		
		query = "select * from bord_reply where mId=?";
		pstm= conn.prepareStatement(query);
		pstm.setInt(1, mId);
		rs= pstm.executeQuery();
			while(rs.next())
			{
				dto = new BordDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getTimestamp(11));
			}
		} catch (Exception e) {

		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			}catch (Exception e) {
			}
		}
		return dto;
	}
	public int replyUpdate(String mGroup,String step) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query="";
		conn=Dbconnect.getConnection();
		try {
			
			query = "update bord_reply set step = step+1 where mGroup =? and step>?";
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, Integer.parseInt(mGroup));
			pstm.setInt(2, Integer.parseInt(step));
			result = pstm.executeUpdate();
		} catch (Exception e) {
		}
		return result;
	}
}
