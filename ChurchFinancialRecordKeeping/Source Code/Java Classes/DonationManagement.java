/*
 Class 		 : Donation Management
 Description : This class helps to connect to Mysql data base and perform CRUD(Create,Read,Update and Delete) operations on Member,Fund and Donation tables.
 */

package church.finance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DonationManagement {
	Connection con = null;
	//Get connection from Mysql DB
	private Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/church finance","root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//Add member to the members table
	public String addMember(Member member){
		String result = "fail";
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			String query = ("insert into members values("
					+ member.getEnvelopeNo()
					+ ",'" + member.getFirstName() + "'"
					+ ",'" + member.getMiddleName() + "'"
					+ ",'" + member.getLastName() + "'"
					+ ",'" + member.getAddress1() + "'"
					+ ",'" + member.getAddress2() + "'"
					+ ",'" + member.getCity() + "'"
					+ ",'" + member.getState() + "'"
					+ ",'" + member.getCountry() + "'"
					+ "," + member.getZipcode()
					+ "," + member.getMobile()
					+ ",'" + member.getEmail() + "')");
			//result = query;
			int value = stmt.executeUpdate(query);	
			
			if(value == 1)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Update members table
	public String updateMember(Member member){
		String result = "fail";
		String sql = "update members set `First Name` = '" + member.getFirstName() + "',"
										+ "`Middle Name` = '" + member.getMiddleName() + "',"
										+ "`Last Name` = '" + member.getLastName() + "',"
										+ "`Address Line1` = '" + member.getAddress1() + "',"
										+ "`Address Line2` = '" + member.getAddress2() + "',"
										+ "`City` = '" + member.getCity() + "',"
										+ "`State` = '" + member.getState() + "',"
										+ "`Country` = '" + member.getCountry() + "',"
										+ "`Zip Code` = " + member.getZipcode() + ","
										+ "`Phone` = " + member.getMobile() 
										+ " where `Envelope Number` = " + member.getEnvelopeNo();
		//System.out.println(sql);
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate(sql);	
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Delete member from the members table
	public String deleteMember(int envelopeNo){
		String result = "fail";
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate("delete from members where `Envelope Number` = " + envelopeNo);	
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Return all members from the members table
	public List<Member> getMembers(){
		List<Member> memberList = new ArrayList<Member>();
		//Member member;
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from Members");	
			while(rs.next()){
				Member member = new Member();
				member.setEnvelopeNo(rs.getInt(1));
				member.setFirstName(rs.getString(2));
				member.setMiddleName(rs.getString(3));
				member.setLastName(rs.getString(4));
				member.setAddress1(rs.getString(5));
				member.setAddress2(rs.getString(6));
				member.setCity(rs.getString(7));
				member.setState(rs.getString(8));
				member.setCountry(rs.getString(9));
				member.setZipcode((rs.getInt(10)));
				member.setMobile(Long.parseLong(rs.getString(11)));
				member.setEmail(rs.getString(12));
				memberList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}
	//Add fund to the fund table
	public String addFund(int fundNo,String fundName){
		String result = "fail";
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate("insert into funds values(" + fundNo + ",'" + fundName + "')");	
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Update fund
	public String updateFund(int fundNo,String fundName){
		String result = "fail";
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate("update funds set `Fund Name` = '" + fundName + "' where `Fund Number` = " + fundNo);	
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Delete fund from the funds table
	public String deleteFund(int fundNo){
		String result = "fail";
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate("delete from funds where `Fund Number` = " + fundNo);	
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Get all funds from the funds table
	public Map<Integer,String> getFunds(){
		Map<Integer,String> fundMap = new HashMap<Integer,String>();
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from funds");	
			while(rs.next()){				
				fundMap.put(rs.getInt(1),rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fundMap;
	}
	//Add donation to the donations table
	public String addDonation(Donation donation){
		String result = "fail";
		String sql = "insert into donations (`Fund Name`,`Amount`,`Amount Type`,`Date`,`Envelope Number`,`Description`) values("
				+ "'" + donation.getFundName() + "'"
				+ "," + donation.getAmount()
				+ ",'" + donation.getAmountType() + "'"
				+ ",'" + donation.getDate() + "'"
				+ "," + donation.getEnvelopeNumber()
				+ ",'" + donation.getDescription() + "')";
		
		//System.out.println(sql);
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate(sql);
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Update donation in donation table
	public String updateDonation(Donation donation){
		String result = "fail";
		String sql = "update donations set `Fund Name` = '" + donation.getFundName() + "'"
				+ ",`Amount` = " + donation.getAmount()
				+ ",`Amount Type` = '" + donation.getAmountType() + "'"
				+ ",`Date` = '" + donation.getDate() + "'"
				+",`Envelope Number` = " + donation.getEnvelopeNumber()
				
				+ " where `Donation ID` = " + donation.getDonationId();		
		//System.out.println(sql);
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate(sql);
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//Delete donation from the donations table
	public String deleteDonation(int donationId){
		String result = "fail";
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			int value = stmt.executeUpdate("delete from donations where `Donation ID` = " + donationId);	
			if(value > 0)
				result = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//Get all donations from donations table
	public List<Donation> getDonations(){
		List<Donation> donationList = new ArrayList<Donation>();
		//Member member;
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from donations");	
			while(rs.next()){
				Donation donation = new Donation();
				donation.setDonationId(rs.getInt(1));
				donation.setEnvelopeNumber(rs.getInt(6));
				donation.setFundName(rs.getString(2));
				donation.setAmount(rs.getDouble(3));
				donation.setAmountType(rs.getString(4));
				donation.setDate(rs.getDate(5));
				donation.setDescription(rs.getString(7));
				donationList.add(donation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donationList;
	}
	//Generate reports from donations table based on user selection
	public List<Report> getReports(String sql){
		List<Report> reportList = new ArrayList<Report>();
		//Member member;
		try {
			Statement stmt = new DonationManagement().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);	
			while(rs.next()){
				Report report = new Report();
				report.setDate(rs.getDate(1));
				report.setAmount(rs.getDouble(2));
				report.setFund(rs.getString(3));
				report.setDescription(rs.getString(4));
				//report.setTotal(rs.getDouble(5));
				reportList.add(report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reportList;
	}
}
