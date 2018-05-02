/*
 Class Name : Member
 Description : It is a java bean for Member class to populate member object from the user 
 			   input and store the member details in to data base.
 */

package church.finance;

public class Member {
	int envelopeNo;
	String firstName;
	String lastName;
	String middleName;
	long mobile;
	String email;
	String address1;
	String address2;
	String city;
	String state;
	String country;
	long zipcode;
	
	public Member() {
		super();
	}

	public Member(int envelopeNo, String firstName, String lastName, String middleName, long mobile, String email,
			String address1, String address2, String city, String state, String country, long zipcode) {
		super();
		this.envelopeNo = envelopeNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.mobile = mobile;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public int getEnvelopeNo() {
		return envelopeNo;
	}

	public void setEnvelopeNo(int envelopeNo) {
		this.envelopeNo = envelopeNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getZipcode() {
		return zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + envelopeNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (envelopeNo != other.envelopeNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [envelopeNo=" + envelopeNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", mobile=" + mobile + ", email=" + email + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + "]";
	}
	
	
}
