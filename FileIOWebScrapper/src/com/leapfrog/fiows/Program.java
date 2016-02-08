/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows;

import com.leapfrog.fiows.dao.EmployeeDAO;
import com.leapfrog.fiows.dao.StudentDAO;
import com.leapfrog.fiows.dao.impl.EmployeeDAOImpol;
import com.leapfrog.fiows.dao.impl.StudentDAOImpl;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.leapfrog.fiows.entity.Student;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
       
        StudentDAO stdDAO=new StudentDAOImpl();
        try {
            stdDAO.loadFromFile("students.csv");
            stdDAO.getAll().forEach(e->{
                System.out.println(e.toString());
            });
            stdDAO.insert(new Student(stdDAO.getAll().size() +1, "Kripesh", "Bista", "kripesh@gmail.com", "2e5702345", true));
            stdDAO.export("students1.csv");
                    
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }
    
}
