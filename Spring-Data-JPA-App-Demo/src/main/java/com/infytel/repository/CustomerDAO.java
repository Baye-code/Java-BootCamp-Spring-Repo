package com.infytel.repository;

import java.util.List;

import com.infytel.entity.Customer;
public interface CustomerDAO {
	// Method to insert a Customer record into the db
    public void insert(Customer customer);
    // Method to remove a Customer record from the db
    public int remove(Long phoneNo);
    // Method to get all the Customer record from the db
    public List<Customer> getAll();
    // Method to update a Customer record from the db
    public void update(Long phoneNo, String address);
} 
