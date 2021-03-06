package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the banks database table.
 * 
 */
@Entity
@Table(name="banks")
@NamedQuery(name="Bank.findAll", query="SELECT b FROM Bank b")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bank_code")
	private Long bankCode;

	@Column(name="bank_name")
	private String bankName;

	@Column(name="bank_sht_desc")
	private String bankShtDesc;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="bank_org_code")
	private Organization organization;

	public Bank() {
	}

	public Long getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(Long bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankShtDesc() {
		return this.bankShtDesc;
	}

	public void setBankShtDesc(String bankShtDesc) {
		this.bankShtDesc = bankShtDesc;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}