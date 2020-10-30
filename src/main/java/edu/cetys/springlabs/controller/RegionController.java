package edu.cetys.springlabs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.cetys.springlabs.service.RegionService;
import edu.cetys.springlabs.exception.RegionNotFoundException;
import edu.cetys.springlabs.model.Region;


@RestController
public class RegionController {

	@Autowired
	RegionService regionService;
	
	
	@GetMapping("/regions")
	public List<Region> findAll() {
		return regionService.findAll();
	}
	

	@GetMapping("/regions/{id}")
	public Region findById(@PathVariable Integer id) {
		
		Optional<Region> region = regionService.findById(id);

		System.out.println("!region.isPresent(): " + !region.isPresent());
		
		if (!region.isPresent()) { 
			throw new RegionNotFoundException(id);
		}      
		
		return region.get();
	}
	
	
	@PostMapping("/regions")
	public Region save(@RequestBody Region region) {
	   return regionService.save(region);
	}
	
	
	@PutMapping("/regions/{id}")
	public Region update(@RequestBody Region updatedRegion, @PathVariable Integer id) {

		Optional<Region> dbRegion = regionService.findById(id);

		if (!dbRegion.isPresent()) { 
			throw new RegionNotFoundException(id);
		}      
		
		Region region = dbRegion.get();
		region.setName(updatedRegion.getName());
		region.setCode(updatedRegion.getCode());
		region.setCountry(updatedRegion.getCountry());
		
		return regionService.update(region);
	  }
	
	
	@DeleteMapping("/regions/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		
		if (id.intValue() != 1) {  // delete region 1 is not allowed
			
			try {
				regionService.deleteById(id);
			} catch(Exception e) {
				throw new RegionNotFoundException(id);
			}
		}
	}
}
