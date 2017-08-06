package com.ak.spring4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min=3, max=50)
	@Column(name = "COMPANY", nullable = false)
	private String company;
	
	@Size(min=3, max=50)
	@Column(name = "FIRST_NAME", nullable = false)
	private String first_name;
	
	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	@Size(min=3, max=50)
	@Column(name = "LAST_NAME", nullable = false)
	private String last_name;
	
	@NotEmpty
    @Column(name = "mobile_phone", unique=true, nullable = false)
    private String mobile_phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	 @Override
	 public int hashCode() {
		 final int prime = 31;
	     int result = 1;
	     result = prime * result + id;
	     result = prime * result + ((mobile_phone == null) ? 0 : mobile_phone.hashCode());
	     return result;
	 }
	 
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof Customer))
	            return false;
	        	Customer other = (Customer) obj;
	        if (id != other.id)
	            return false;
	        if (mobile_phone == null) {
	            if (other.mobile_phone != null)
	                return false;
	        } else if (!mobile_phone.equals(other.mobile_phone))
	            return false;
	        return true;
	    }
	 
	    @Override
	    public String toString() {
	        return "Customer [Id=" + id + ", First Name=" + first_name + ", Last Name="
	                + last_name + ", Mobile Phone =" + mobile_phone + "]";
	    }
}
