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

@Entity(name = "city_model") // This tells Hibernate to make a table out of this class
@Table(name = "city_model")
public class CityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = StateModel.class)
    @JoinColumn(name = "state_id")
    private StateModel state;

    @OneToMany(mappedBy = "city")
    private List<DistrictModel> districts;

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

    public StateModel getState() {
        return state;
    }

    public void setState(StateModel state) {
        this.state = state;
    }

    public List<DistrictModel> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictModel> districts) {
        this.districts = districts;
    }
}