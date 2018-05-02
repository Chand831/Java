/*
 Class Name  : Report
 Description : It is a java bean for report class to populate reports object from the user 
 			   input and it will populate query based on user input.
 */

package church.finance;

import java.sql.Date;

public class Report {
	String sql;
	Date date;
	double amount;
	String fund;
	String description;	
	
	
	
	public Report() {
		super();
	}



	public Report(Date date, double amount, String fund, String description) {
		super();
		this.date = date;
		this.amount = amount;
		this.fund = fund;
		this.description = description;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getFund() {
		return fund;
	}



	public void setFund(String fund) {
		this.fund = fund;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getReportQuery(Date from,Date to,int env,String fund,String fn,String ln){
		if(from == null && to == null && env == 0 && fund == null && fn == null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations";
		}

		            

		if(from == null && to == null && env == 0 && fund == null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')";
		}

		            

		if(from == null && to == null && env == 0 && fund == null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')";
		}


		              

		if(from == null && to == null && env == 0 && fund == null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "' and `First Name` = '" + fn + "')";
		}


		            

		if(from == null && to == null && env == 0 && fund != null && fn == null && ln == null){
			
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "'";
		}

		                

		if(from == null && to == null && env == 0 && fund != null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')"; 
		}

		                

		if(from == null && to == null && env == 0 && fund != null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')";
		}

		              

		if(from == null && to == null && env == 0 && fund != null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "' and `First Name` = '" + fn + "')";
		}

		              

		if(from == null && to == null && env != 0 && fund == null && fn == null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env ;
		}

		             

		if(from == null && to == null && env != 0 && fund == null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env ;
		}

		               

		if(from == null && to == null && env != 0 && fund == null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env ;
		}

		              

		if(from == null && to == null && env != 0 && fund == null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env ;
		}

		               

		if(from == null && to == null && env != 0 && fund != null && fn == null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env  + " and `Fund Name` = '" + fund + "'";
		}

		              

		if(from == null && to == null && env != 0 && fund != null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env  + " and `Fund Name` = '" + fund + "'";
		}

		                

		if(from == null && to == null && env != 0 && fund != null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env  + " and `Fund Name` = '" + fund + "'";
		}

		               

		if(from == null && to == null && env != 0 && fund != null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env  + " and `Fund Name` = '" + fund + "'";
		}

		             

		if(from == null && to != null && env == 0 && fund == null && fn == null && ln == null){
			
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "'";
		}

		             

		if(from == null && to != null && env == 0 && fund == null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')";
		}

		             

		if(from == null && to != null && env == 0 && fund == null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')";
		}

		              

		if(from == null && to != null && env == 0 && fund == null && fn != null && ln != null){
			
		sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "' and `First Name` = '" + fn + "')";
		}

		             

		if(from == null && to != null && env == 0 && fund != null && fn == null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "'";
		}

		              

		if(from == null && to != null && env == 0 && fund != null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')"; 
		}

		              

		if(from == null && to != null && env == 0 && fund != null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')"; 
		}

		               

		if(from == null && to != null && env == 0 && fund != null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "' and `First Name` = '" + fn + "')";
		}

		             

		if(from == null && to != null && env != 0 && fund == null && fn == null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Envelope Number` = " + env ;
		}

		              

		if(from == null && to != null && env != 0 && fund == null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Envelope Number` = " + env ;
		}

		               

		if(from == null && to != null && env != 0 && fund == null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Envelope Number` = " + env ;
		}

		               

		if(from == null && to != null && env != 0 && fund == null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Envelope Number` = " + env ;
		}

		              

		if(from == null && to != null && env != 0 && fund != null && fn == null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		               

		if(from == null && to != null && env != 0 && fund != null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		               

		if(from == null && to != null && env != 0 && fund != null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		                

		if(from == null && to != null && env != 0 && fund != null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` <= '" + to + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		            

		if(from != null && to == null && env == 0 && fund == null && fn == null && ln == null){
			
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "'";
		}

		             

		if(from != null && to == null && env == 0 && fund == null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')";
		}

		             

		if(from != null && to == null && env == 0 && fund == null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')";
		}

		              

		if(from != null && to == null && env == 0 && fund == null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "' and `First Name` = '" + fn + "')";
		}

		             

		if(from != null && to == null && env == 0 && fund != null && fn == null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "'";
		}

		              

		if(from != null && to == null && env == 0 && fund != null && fn == null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')";
		}

		              

		if(from != null && to == null && env == 0 && fund != null && fn != null && ln == null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')";
		}

		               

		if(from != null && to == null && env == 0 && fund != null && fn != null && ln != null){

			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "' and `First Name` = '" + fn + "')";
		}

		             

		if(from != null && to == null && env != 0 && fund == null && fn == null && ln == null){
			
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Envelope Number` = " + env;
		}

		              

		if(from != null && to == null && env != 0 && fund == null && fn == null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Envelope Number` = " + env;
		}

		              

		if(from != null && to == null && env != 0 && fund == null && fn != null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Envelope Number` = " + env;
		}

		               

		if(from != null && to == null && env != 0 && fund == null && fn != null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Envelope Number` = " + env;
		}

		              

		if(from != null && to == null && env != 0 && fund != null && fn == null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		               

		if(from != null && to == null && env != 0 && fund != null && fn == null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		               


		if(from != null && to == null && env != 0 && fund != null && fn != null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		                

		if(from != null && to == null && env != 0 && fund != null && fn != null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` >= '" + from + "' and `Fund Name` = '" + fund + "' and `Envelope Number` = " + env ;
		}

		             

		if(from != null && to != null && env == 0 && fund == null && fn == null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` between '" + from + "' and '" + to + "'";
		}

		              

		if(from != null && to != null && env == 0 && fund == null && fn == null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` between '" + from + "' and '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')";
		}

		              

		if(from != null && to != null && env == 0 && fund == null && fn != null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` between '" + from + "' and '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')";
		}

		               

		if(from != null && to != null && env == 0 && fund == null && fn != null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Date` between '" + from + "' and '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "' and `Last Name` = '" + ln + "')";
		}

		              

		if(from != null && to != null && env == 0 && fund != null && fn == null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Date` between '" + from + "' and '" + to + "'";
		}

		               

		if(from != null && to != null && env == 0 && fund != null && fn == null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Date` between '" + from + "' and '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `Last Name` = '" + ln + "')";
		}

		               

		if(from != null && to != null && env == 0 && fund != null && fn != null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Date` between '" + from + "' and '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "')";
		}

		                

		if(from != null && to != null && env == 0 && fund != null && fn != null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Date` between '" + from + "' and '" + to + "' and `Envelope Number` in (select `Envelope Number` from members where `First Name` = '" + fn + "' and `Last Name` = '" + ln + "')";
		}

		              

		if(from != null && to != null && env != 0 && fund == null && fn == null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";
		}

		               

		if(from != null && to != null && env != 0 && fund == null && fn == null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";
		}

		                

		if(from != null && to != null && env != 0 && fund == null && fn != null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";
		}

		                

		if(from != null && to != null && env != 0 && fund == null && fn != null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";
		}

		               

		if(from != null && to != null && env != 0 && fund != null && fn == null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";
		}

		                

		if(from != null && to != null && env != 0 && fund != null && fn == null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";

		}

		                

		if(from != null && to != null && env != 0 && fund != null && fn != null && ln == null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";

		}

		                 

		if(from != null && to != null && env != 0 && fund != null && fn != null && ln != null){
			sql = "select `date`,`amount`,`Fund Name`,`description` from donations where `Fund Name` = '" + fund + "' and `Envelope Number` = " + env + " and `Date` between '" + from + "' and '" + to + "'";

		}

		return sql;
	}
}
