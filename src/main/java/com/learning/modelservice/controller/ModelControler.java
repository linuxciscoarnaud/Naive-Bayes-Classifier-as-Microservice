/**
 * 
 */
package com.learning.modelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.modelservice.service.ModelService;

/**
 * @author Arnaud
 *
 */

@RestController
public class ModelControler {

	@Autowired
	private ModelService modelService;
	
	@GetMapping("/{outlook}/{temperature}/{humidity}/{windy}")
	public String getPrediction(@PathVariable("outlook") String outlook,
			                    @PathVariable("temperature") String temperature,
			                    @PathVariable("humidity") String humidity,
			                    @PathVariable("windy") String windy) throws Exception {
		
		return modelService.getPrediction(outlook, temperature, humidity, windy);
	}
}
