package com.learning.modelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.modelservice.classifier.NaiveBayesClassifier;

@SpringBootApplication
public class ModelServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ModelServiceApplication.class, args);
		
		NaiveBayesClassifier NaiveBayesClassifier = new NaiveBayesClassifier();
		NaiveBayesClassifier.buildClassifier();
	}
}

