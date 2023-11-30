package com.demo.operations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
@Table(name = "accounts", schema = "public")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private Long accountId;
	
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_branch")
	private String bankBranch;
	
	@Column(name="balance")
	private Long balance;
}
