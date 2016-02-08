/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows.dao.impl;

import com.leapfrog.fiows.dao.StudentDAO;
import com.leapfrog.fiows.entity.Student;
import com.leapfrog.fiows.util.CSVHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class StudentDAOImpl implements StudentDAO{

    private List<Student> studentList=new ArrayList<>();
    @Override
    public void insert(Student t) {
        studentList.add(t);
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void loadFromFile(String fileName) throws IOException {
        CSVHandler.read(fileName).forEach(r->{
            StringTokenizer tokens=new StringTokenizer(r,",");
            
            if(tokens.countTokens() >=6){
                Student s=new Student();
                s.setId(Integer.parseInt(tokens.nextToken()));
                s.setFirstName(tokens.nextToken());
                s.setLastName(tokens.nextToken());
                s.setEmail(tokens.nextToken());
                s.setContactNo(tokens.nextToken());
                s.setStatus(Boolean.parseBoolean(tokens.nextToken()));
                
                insert(s);
            }
            
        });
    }

    @Override
    public void export(String fileName) throws IOException {
        StringBuilder builder=new StringBuilder();
        for(Student s: studentList){
            builder.append(s.toCSV());
        }
        
        CSVHandler.write(fileName, builder.toString());
    }
    
}
