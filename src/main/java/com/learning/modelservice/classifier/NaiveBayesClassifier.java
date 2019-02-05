/**
 * 
 */
package com.learning.modelservice.classifier;

import org.springframework.core.io.ClassPathResource;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

/**
 * @author Arnaud
 *
 */

public class NaiveBayesClassifier {

	// The filter
	private StringToWordVector filter = new StringToWordVector();
		
	public static NaiveBayes naiveBayes = new NaiveBayes();
	
	public void buildClassifier() throws Exception {	
		
		// Load the ARFF file containing the training data
		System.out.println("Loading training data...");
		ArffLoader loader = new ArffLoader();
		loader.setSource(new ClassPathResource("train_data.arff").getFile());
		Instances train_dataset = loader.getDataSet();
		
		// Set the datasets to the last attributes
		train_dataset.setClassIndex(train_dataset.numAttributes() - 1);
		
		// Pass the data set to the filter
		filter.setInputFormat(train_dataset);
		
		// Apply the filter
		train_dataset = Filter.useFilter(train_dataset, filter);
		
		// Build the classifier
		System.out.println("Building the classifier...");
		naiveBayes.buildClassifier(train_dataset);
	}
}
