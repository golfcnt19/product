package com.java.Product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Pro> listAll() {
		return repo.findAll();
	}
	
	public void save(Pro product) {
        repo.save(product);
    }
     
    public Pro get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
