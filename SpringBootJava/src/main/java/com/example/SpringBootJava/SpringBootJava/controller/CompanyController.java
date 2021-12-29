
package com.example.SpringBootJava.SpringBootJava.controller;

import com.example.SpringBootJava.SpringBootJava.model.Company;
import com.example.SpringBootJava.SpringBootJava.repository.CompanyRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies(){
        try {
            List<Company> companies = new ArrayList<Company>();
            
            
                companyRepository.findAll().forEach(companies::add);
            
            if (companies.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
            return new ResponseEntity<>(companies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") long id){
        Company company = companyRepository.findById(id);
        
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/company")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        try {
            companyRepository.save(new Company(company.getCompanyName(), company.getBasedOn()));
            return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/company/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable("id") long id, @RequestBody Company company){
        Company _company = companyRepository.findById(id);
        
        if (_company !=null) {
            _company.setId(id);
            _company.setCompanyName(company.getCompanyName());
            _company.setBasedOn(company.getBasedOn());
            
            companyRepository.update(_company);
            return new ResponseEntity<>("Company was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find company with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/company/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id){
        try {
            int result = companyRepository.deleteById(id);
            if (result == 0) {
        return new ResponseEntity<>("Cannot find Company with id=" + id, HttpStatus.OK);
      }
            return new ResponseEntity<>("Company was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete tutorial.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
