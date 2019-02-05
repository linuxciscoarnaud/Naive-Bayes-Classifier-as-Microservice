/**
 * 
 */
package com.learning.modelservice.repository;

/**
 * @author Arnaud
 *
 */

public interface ModelRepository {

	public String getPrediction(String valOutlook,
                                String valTemperature,
                                String valUumidity,
                                String valWindy) throws Exception;
}
