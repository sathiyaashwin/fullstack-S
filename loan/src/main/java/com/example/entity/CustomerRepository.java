package com.example.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ifaces.CrudRepository;

public class CustomerRepository implements CrudRepository<LoanApplication> {
	

private Connection con;
	
	public CustomerRepository(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(LoanApplication obj) {
		int rowAdded1=0;
		int rowAdded2=0;
		String sql = "Insert into Sathiyaa_customer values(?,?,?,?)";
		String sql1 = "Insert into Sathiyaa_loan_application values(?,?,?)";
		
		try(PreparedStatement ps1 =con.prepareStatement(sql);
			PreparedStatement ps2 = con.prepareStatement(sql1)){
			
			ps1.setInt(1,obj.getCustomer().getCustomer_Id());
			ps1.setString(2,obj.getCustomer().getCustomer_Name());
			ps1.setLong(3,obj.getCustomer().getPhone_Number());
			ps1.setDouble(4,obj.getCustomer().getCredit_score());
			
			rowAdded1=ps1.executeUpdate();
			
			ps2.setInt(1,obj.getLoanApplicationNumber());
			ps2.setInt(2,obj.getCustomer().getCustomer_Id());
			ps2.setDouble(3,obj.getLoanAmount());
			
			rowAdded2=ps2.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return rowAdded2;
	}

	@Override
	public List<LoanApplication> findAll() {
		
		List<LoanApplication> customerlist = new ArrayList<LoanApplication>();
		String sql ="select sc.customer_id,sc.customer_name,sc.phone_number,sc.credit_score,sl.application_number,sl.customer,sl.loan_amount "
				+ "from sathiyaa_loan_application sl,sathiyaa_customer sc "
				+ "where sc.customer_id=sl.customer";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				int customerId = rs.getInt("customer_id");
				String customerName = rs.getString("customer_name");
				long phoneNumber = rs.getLong("phone_number");
				double creditScore = rs.getDouble("credit_score");
				int loanAppNo = rs.getInt("application_number");
				double loanamount = rs.getDouble("loan_amount");
				
				Customer cus = new Customer(customerId,customerName,phoneNumber,creditScore);
				
				LoanApplication loan = new LoanApplication(loanAppNo,cus,loanamount);
				customerlist.add(loan);
				
			}
			
		}catch(Exception e) {
		e.printStackTrace();
		}
		return customerlist;
	}

	@Override
	public int remove(int id) {
		int rowdeleted=0;
		String sql = "delete from sathiyaa_loan_application where application_number =?";
				
		try(PreparedStatement ps = con.prepareStatement(sql)){
					
			ps.setInt(1,id);
			rowdeleted= ps.executeUpdate();
					
			}catch(Exception e) {
			e.printStackTrace();
			}
	return rowdeleted;
	}

	@Override
	public Optional<LoanApplication> findById(int id) {
		
		Optional<LoanApplication> op = Optional.empty();
		
		
		
		return null;
	}

	@Override
	public int update(int Id, LoanApplication obj) {
		// TODO Auto-generated method stub
		return 0;
	}
}
