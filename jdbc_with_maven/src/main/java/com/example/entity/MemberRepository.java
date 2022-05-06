package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.time.LocalDate;

import com.example.ifaces.CrudRepository;

public class MemberRepository implements CrudRepository<Member> {
	
	private Connection con;
	
	public MemberRepository(Connection con) {
		super();
		this.con = con;
	}

	public int add(Member obj) {
		int rowAdded = 0;
		
		String sql = "insert into sathiyaa_member values(?,?,?,?,?,?,?,?)";
				
				try(PreparedStatement pstmt = con.prepareStatement(sql)) {
					
					pstmt.setInt(1,obj.getMemberId());
					pstmt.setString(2,obj.getMemberName());
					pstmt.setString(3,obj.getMemberAddress());
					pstmt.setDate(4,(Date) obj.getAccountOpenDate());
					pstmt.setString(5,obj.getMemberShipType());
					pstmt.setDouble(6,obj.getFeesPaid());
					pstmt.setInt(7,obj.getMaxBookAllowed());
					pstmt.setDouble(8,obj.getPenaltyAmount());
					
					rowAdded = pstmt.executeUpdate();
					
					
			}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowAdded;
	}

	public List<Member> findAll() {
		List<Member> memberList = new ArrayList<Member>();
		String sql = "Select * from sathiyaa_member";
		
		try(PreparedStatement pstmt =con.prepareStatement(sql)){
			
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			
				int memberId = rs.getInt("Member_Id");
				String memberName = rs.getString("Member_Name");
				String memberAddress = rs.getString("Member_address");
				Date accountOpenDate=rs.getDate("Acc_Open_Date");
				String memberShipType = rs.getString("Membership_type");
				double feesPaid = rs.getInt("Fees_paid");
				int maxBooksAllowed = rs.getInt("Max_Books_Allowed");	
				double penaltyAmount = rs.getDouble("Penalty_Amount");
				
				Member obj= new Member(memberId, memberName, memberAddress, accountOpenDate, memberShipType, feesPaid, maxBooksAllowed, penaltyAmount);
				memberList.add(obj);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return memberList;
	}

	public int remove(int id) {

		int rowsDeleted = 0;
		String sql ="delete from sathiyaa_member where member_Id =?";
		
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1,id);
				rowsDeleted = pstmt.executeUpdate();
				
			}catch (SQLException e) {
				 e.printStackTrace();
		}
		return rowsDeleted;
	}
	public Optional<Member> findById(int id) {
		
		Optional<Member> obj = Optional.empty();
		
		String sql = "select * from sathiyaa_member where member_id=?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
		
		pstmt.setInt(1, id);
		
		ResultSet result = pstmt.executeQuery();
		
		if(result.next()){
		
			int memberId =result.getInt("member_id");
			String memberName = result.getString("member_name");
			String memberAddress = result.getString("member_address");
			Date accountOpenDate = result.getDate("acc_open_date");
			String memberShipType = result.getString("membership_type");
			double feesPaid = result.getInt("fees_paid");
			int maxBooksAllowed = result.getInt("max_books_allowed");
			double penaltyAmount = result.getInt("penalty_amount");
			
			
			Member mem= new Member(memberId, memberName, memberAddress, accountOpenDate, memberShipType, feesPaid, maxBooksAllowed, penaltyAmount);
			
			obj=Optional.of(mem);
		}
		}catch(SQLException e){
		
		e.printStackTrace();
		
		}
		return obj;
	}
	

	public int update1(int id, String obj) {
		
		int rowsUpdated=0;
		String sql = "update sathiyaa_member set member_name=? where member_id=?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
		
		pstmt.setString(1, obj);
		pstmt.setInt(2, id);
		
		rowsUpdated = pstmt.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return rowsUpdated;
	}

	@Override
	public int update(int Id, Member obj) {
		// TODO Auto-generated method stub
		return 0;
	}
}
