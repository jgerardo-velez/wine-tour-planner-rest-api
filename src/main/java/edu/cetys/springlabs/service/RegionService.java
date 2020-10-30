package edu.cetys.springlabs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cetys.springlabs.repository.RegionRepository;
import edu.cetys.springlabs.model.Region;


@Service
public class RegionService {

	@Autowired
	RegionRepository regionRepository;
	
	
	public List<Region> findAll() {
		
		return regionRepository.findAll();	
	}
	
	
	public Optional<Region> findById(Integer id) {
		
		return regionRepository.findById(id);	
	}
	
	
	public Region save(Region region) {
		
		return regionRepository.save(region);
	}
	
	
	public Region update(Region region) {
		
		return regionRepository.save(region);
	}
	
	
	public void deleteById(Integer id) {
		
		regionRepository.deleteById(id);
	}
	
}
