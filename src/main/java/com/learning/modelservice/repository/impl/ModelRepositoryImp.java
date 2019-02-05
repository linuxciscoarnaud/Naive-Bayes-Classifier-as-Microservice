/**
 * 
 */
package com.learning.modelservice.repository.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.learning.modelservice.repository.ModelRepository;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

/**
 * @author Arnaud
 *
 */

@Repository
public class ModelRepositoryImp implements ModelRepository {
	
	/* (non-Javadoc)
	 * @see com.learning.modelservice.repository.ModelRepository#getPrediction(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getPrediction(String valOutlook, String valTemperature, String valUumidity, String valWindy) throws Exception {		
		// TODO Auto-generated method stub
		
		// The filter
		StringToWordVector filter = new StringToWordVector();
		
		ArrayList<String> classVal = new ArrayList<String>();
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		
		classVal.add("yes");
		classVal.add("no");
		
		attributes.add(new Attribute("outlook", (ArrayList<String>)null));
		attributes.add(new Attribute("temperature", (ArrayList<String>)null));
		attributes.add(new Attribute("humidity", (ArrayList<String>)null));
		attributes.add(new Attribute("windy", (ArrayList<String>)null));
		attributes.add(new Attribute("class", classVal));
		
		Instances test_data = new Instances("TestInstances", attributes, 0);
		
		double[] instanceVal = new double[test_data.numAttributes()];
		instanceVal[0] = test_data.attribute(0).addStringValue(valOutlook);
		instanceVal[1] = test_data.attribute(1).addStringValue(valTemperature);
		instanceVal[2] = test_data.attribute(2).addStringValue(valUumidity);
		instanceVal[3] = test_data.attribute(3).addStringValue(valWindy);
		//instanceVal[4] = 1;
		
		test_data.add(new DenseInstance(1.0, instanceVal));
		
		// Set the test data to the last attributes
		test_data.setClassIndex(test_data.numAttributes() - 1);
		
		// Pass the test data to the filter
		filter.setInputFormat(test_data);
		
		// Apply the filter
		test_data = Filter.useFilter(test_data, filter);
		
		double index = com.learning.modelservice.classifier.NaiveBayesClassifier
				          .naiveBayes.classifyInstance(test_data.instance(0));
		
		return test_data.classAttribute().value((int)index);
	}
}
