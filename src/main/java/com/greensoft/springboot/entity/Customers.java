package com.greensoft.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "customer_name")
	private String customerName;
	private String rmn;
	private String email;
	@Column(name = "company_name")
	private String companyName;
	private String pan;
	private String tan;
	@Column(name = "gst_id")
	private String gstId;
//	@Column(name = "admin_user_id")
//	private String adminUserId;
//	CUSTOMERID
//	CUSTOMERNAME
//	RMN
//	EMAIL
//	COMPANYNAME
//	PAN
//	TAN
//	GSTID
//	ADMINUSERID

}
