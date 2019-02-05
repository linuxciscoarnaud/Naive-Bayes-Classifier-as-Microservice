/**
 * 
 */
package com.learning.modelservice.service;

/**
 * @author Arnaud
 *
 */

public interface ModelService {

	public String getPrediction(String valOutlook,
			                    String valTemperature,
			                    String valUumidity,
			                    String valWindy) throws Exception;
}
