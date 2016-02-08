/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows.dao;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GenericDAO<T>{
    void insert(T t);
    List<T> getAll();
    void loadFromFile(String fileName) throws IOException;
    void export(String fileName)throws IOException;
    
}
