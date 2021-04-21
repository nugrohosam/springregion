package com.nugrohosamiyono.springregion.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "state_model") // This tells Hibernate to make a table out of this class
@Table(name = "state_model")
public class StateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = CountryModel.class)
    @JoinColumn(name = "country_id")
    private CountryModel country;

    @OneToMany(mappedBy = "state")
    public List<CityModel> cities;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryModel getCountry() {
        return country;
    }

    public void setCountry(CountryModel country) {
        this.country = country;
    }

    public List<CityModel> getCities() {
        return cities;
    }

    public void setCities(List<CityModel> cities) {
        this.cities = cities;
    }
}
