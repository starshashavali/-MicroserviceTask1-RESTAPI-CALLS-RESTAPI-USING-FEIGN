package com.gis.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="STUDENT-REST-API",url = "${studentApiUrl}")
public interface IFeignclient {


	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id);	

	
	
}


