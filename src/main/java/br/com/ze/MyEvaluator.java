package br.com.ze;

import java.io.IOException;

import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.common.RandomUtils;

public class MyEvaluator {
	
	public static void main(String[] args) throws IOException, Exception {
		RandomUtils.useTestSeed();

		FileDataModel model = new DataModelBuilder().getCoursesModel();

		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		double error = evaluator.evaluate(new MyRecommenderBuilder(), null, model, 0.9, 1.0);
		
		System.out.println(error);
	}
}