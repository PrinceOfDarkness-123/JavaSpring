
package com.example.SpringBootJava.SpringBootJava.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringBootJava.SpringBootJava.model.Company;

@Repository
public class JdbcCompanyRepository implements CompanyRepository{
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public int save(Company company){
        return jdbcTemplate.update("INSERT INTO company (company_name, based_on) VALUES(?,?)",
                new Object[]{
                    company.getCompanyName(),
                    company.getBasedOn()
                });
    }
    @Override
    public int update(Company company){
        return jdbcTemplate.update("UPDATE company SET company_name=?, based_on=? WHERE id=",
                new Object[]{
                    company.getCompanyName(),
                    company.getBasedOn(),
                    company.getId()
                });
    }
    @Override
    public Company findById(Long id){
        try {
            Company company = jdbcTemplate.queryForObject("SELECT * FROM company WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Company.class), id);
            return company;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    @Override
    public int deleteById(Long id){
        return jdbcTemplate.update("DELETE FROM company WHERE id=?", id);
    }
    @Override
  public List<Company> findAll() {
    return jdbcTemplate.query("SELECT * from company", BeanPropertyRowMapper.newInstance(Company.class));
  }
    
    
}
