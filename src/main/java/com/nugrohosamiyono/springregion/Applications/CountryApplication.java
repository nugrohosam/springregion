package com.nugrohosamiyono.springregion.Applications;

import java.util.Optional;

import com.nugrohosamiyono.springregion.Models.CountryModel;
import com.nugrohosamiyono.springregion.Repositories.CountryRepository;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.Country.CountryCreate;
import com.nugrohosamiyono.springregion.Requests.Country.CountryUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryApplication {

    @Autowired
    private CountryRepository countryRepository;

    public void createCountryFromAPI(CountryCreate countryCreate) {

        CountryModel newCountry = new CountryModel();
        newCountry.setName(countryCreate.name);

        this.countryRepository.save(newCountry);
    }

    public void updateCountryFromAPI(Integer id, CountryUpdate countryUpdate) {
        Optional<CountryModel> countryOpt = this.countryRepository.findById(id);

        CountryModel updatCountry = countryOpt.get();
        updatCountry.setName(countryUpdate.name);
        this.countryRepository.save(updatCountry);
    }

    public void deleteCountryFromAPI(Integer id) {
        this.countryRepository.deleteById(id);
    }

    public Iterable<CountryModel> getCountryFromAPI(QueryParams queryParams) {
        int offset = (queryParams.getPage() - 1) * queryParams.getPage();
        return this.countryRepository.findAllLimitOffsetByCustomQuery(queryParams.getSearch(), offset, queryParams.getPerPage());
    }

    public CountryModel detailCountry(Integer id) {
        Optional<CountryModel> countOpt = this.countryRepository.findById(id);
        if (countOpt.isEmpty()){
            return (new CountryModel());
        }
        
        return countOpt.get();
    }
}
