/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows.dao.impl;

import com.leapfrog.fiows.dao.EmployeeDAO;
import com.leapfrog.fiows.entity.Employee;
import com.leapfrog.fiows.util.CSVHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class EmployeeDAOImpol implements EmployeeDAO{

    private List<Employee> empList=new ArrayList<>();
    @Override
    public void insert(Employee t) {
        empList.add(t);
    }

    @Override
    public List<Employee> getAll() {
        return empList;
    }

    @Override
    public void loadFromFile(String fileName) throws IOException {
        CSVHandler.read(fileName).forEach(r->{
            StringTokenizer tokens=new StringTokenizer(r,",");
            
            if(tokens.countTokens() >=6){
                Employee e=new Employee();
                e.setId(Integer.parseInt(tokens.nextToken()));
                e.setFirstName(tokens.nextToken());
                e.setLastName(tokens.nextToken());
                e.setEmail(tokens.nextToken());
                e.setContactNo(tokens.nextToken());
                e.setStatus(Boolean.parseBoolean(tokens.nextToken()));
                
                insert(e);
            }
            
        });
    }

    @Override
    public void export(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
