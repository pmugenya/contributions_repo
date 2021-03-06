package org.tracsystems.apps.brokerage.setups.model;

import java.io.Serializable;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the counties database table.
 * 
 */
@Entity
@Table(name="counties")
@NamedQuery(name="County.findAll", query="SELECT c FROM County c")
public class County implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="county_id")
	private Long countyId;

	@Column(name="county_code")
	private String countyCode;

	@Column(name="county_name")
	private String countyName;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="county_cou_code")
	@JsonBackReference
	private Country country;

	//bi-directional many-to-one association to Town
	@JsonManagedReference
	@OneToMany(mappedBy="county")
	private List<Town> towns;

	public County() {
	}

	public Long getCountyId() {
		return this.countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return this.countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Town> getTowns() {
		return this.towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public Town addTown(Town town) {
		getTowns().add(town);
		town.setCounty(this);

		return town;
	}

	public Town removeTown(Town town) {
		getTowns().remove(town);
		town.setCounty(null);

		return town;
	}

}