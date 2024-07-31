package com.register;

public class memberord {
	private String name,email, address,foodname;
	private String quantity;

	public memberord() {
		super();
	}

	public memberord(String name, String email, String address, String foodname, String quantity) {
		super();
		this.name= name;
		this.email = email;
		this.address= address;
		this.foodname= foodname;
		this.quantity= quantity;
	}

	public String getuname() {
		return name;
	}

	public void setuname(String name) {
		this.name = name;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	

	public String getfoodname() {
		return foodname;
	}

	public void setfoodname(String foodname) {
		this.foodname = foodname;
	}
	
	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}


}



