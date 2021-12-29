
package com.example.SpringBootJava.SpringBootJava.repository;

import java.util.List;


import com.example.SpringBootJava.SpringBootJava.model.Company;

public interface CompanyRepository {
    int save(Company company);

  int update(Company company);
  
  Company findById(Long id);
  int deleteById(Long id);
  List<Company> findAll();

 

  
}


