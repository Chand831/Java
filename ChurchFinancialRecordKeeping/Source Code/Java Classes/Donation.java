/*
 Class Name : Donation
 Description : It is a java bean for donation class to populate donation object from the user 
 			   input and store the donation details in to data base.
 */


package church.finance;

import java.sql.Date;

public class Donation {
	int donationId;
	int envelopeNumber;
	String fundName;
	double amount;
	String amountType;
	Date date;
	String description;
	
	public Donation() {
		super();
	}	

	public Donation(int envelopeNumber, String fundName, double amount, String amountType, Date date,
			String description) {
		super();
		this.envelopeNumber = envelopeNumber;
		this.fundName = fundName;
		this.amount = amount;
		this.amountType = amountType;
		this.date = date;
		this.description = description;
	}

	

	public Donation(int donationId, int envelopeNumber, String fundName, double amount, String amountType, Date date,
			String description) {
		super();
		this.donationId = donationId;
		this.envelopeNumber = envelopeNumber;
		this.fundName = fundName;
		this.amount = amount;
		this.amountType = amountType;
		this.date = date;
		this.description = description;
	}



	public int getDonationId() {
		return donationId;
	}



	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}



	public int getEnvelopeNumber() {
		return envelopeNumber;
	}

	public void setEnvelopeNumber(int envelopeNumber) {
		this.envelopeNumber = envelopeNumber;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getAmountType() {
		return amountType;
	}



	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}



	@Override
	public String toString() {
		return "Donation [envelopeNumber=" + envelopeNumber + ", fundName=" + fundName + ", amount=" + amount
				+ ", amountType=" + amountType + ", date=" + date + ", description=" + description + "]";
	}
	
	
}
