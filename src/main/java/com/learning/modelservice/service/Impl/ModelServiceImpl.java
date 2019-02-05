/**
 * 
 */
package com.learning.modelservice.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.modelservice.repository.ModelRepository;
import com.learning.modelservice.service.ModelService;

/**
 * @author Arnaud
 *
 */

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelRepository modelRepository;
	
	/* (non-Javadoc)
	 * @see com.learning.modelservice.service.ModelService#getPrediction(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getPrediction(String valOutlook, 
			                    String valTemperature, 
			                    String valHumidity, 
			                    String valWindy) throws Exception {
		// TODO Auto-generated method stub
		return modelRepository.getPrediction(valOutlook, valTemperature, valHumidity, valWindy);
	}

}
