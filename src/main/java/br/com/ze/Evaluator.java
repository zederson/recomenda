package br.com.ze;

import java.io.IOException;

import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;

public class Evaluator {
	
	public static void main(String[] args) throws IOException, Exception {
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		
		FileDataModel model = new ProductRecomender().getDataModel();
		RecommenderBuilder builder = new ProductEvaluator();
		double error = evaluator.evaluate(builder, null, model, 0.9, 1.0);
		
		System.out.println(error);
	}

}
