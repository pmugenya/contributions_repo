package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the countries database table.
 * 
 */
@Entity
@Table(name="countries")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cou_code")
	private Long couCode;

	@Column(name="cou_name")
	private String couName;

	@Column(name="cou_sht_desc")
	private String couShtDesc;

	

	//bi-directional many-to-one association to County
	@JsonManagedReference
	@OneToMany(mappedBy="country",cascade=CascadeType.ALL)
	private List<County> counties;

	public Country() {
	}

	public Long getCouCode() {
		return this.couCode;
	}

	public void setCouCode(Long couCode) {
		this.couCode = couCode;
	}

	public String getCouName() {
		return this.couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getCouShtDesc() {
		return this.couShtDesc;
	}

	public void setCouShtDesc(String couShtDesc) {
		this.couShtDesc = couShtDesc;
	}


	public List<County> getCounties() {
		return this.counties;
	}

	public void setCounties(List<County> counties) {
		this.counties = counties;
	}

	public County addCounty(County county) {
		getCounties().add(county);
		county.setCountry(this);

		return county;
	}

	public County removeCounty(County county) {
		getCounties().remove(county);
		county.setCountry(null);

		return county;
	}

}