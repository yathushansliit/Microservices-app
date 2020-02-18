package com.kayal.allocationservice.controller;

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

import com.kayal.allocationservice.model.Allocation;
import com.kayal.allocationservice.service.AllocationService;

@RestController
public class AllocationController {

	@Autowired
	AllocationService allocationService;
	
	@PostMapping("/allocation")
	public Allocation addAllocation(@RequestBody Allocation allocation) {
		return allocationService.createAllocation(allocation);
	}
	
	@GetMapping("/allocations")
	public List<Allocation> getAllocations(){
		return allocationService.getAllocations();
	}
	
	@GetMapping("/allocation/{allocationId}")
	public Optional<Allocation> getAllocationRecord(@PathVariable(value = "allocationId") Integer id){
		return allocationService.getAllocationById(id);
	}
	
	@PutMapping("/allocation/{allocationId}")
	public Allocation updateAllocationRecord(@RequestBody Allocation allocation, @PathVariable(value = "allocationId") Integer id) {
		return allocationService.updateAllocation(allocation, id);
	}
	
	@DeleteMapping("/allocation/{allocationId}")
	public void deleteAllocationRecord(@PathVariable(value = "allocationId") Integer id) {
		allocationService.deleteAllocation(id);
	}
}
