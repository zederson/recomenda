package br.com.ze;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class ProductRecomender {

	public static void main(String[] args) throws Exception {
		FileDataModel model = new ProductRecomender().getDataModel();
		RecommenderBuilder builder = new ProductEvaluator();
		GenericUserBasedRecommender recommender = (GenericUserBasedRecommender) builder.buildRecommender(model);

		List<RecommendedItem> recommendations = recommender.recommend(2, 3);
		for (RecommendedItem recommendedItem : recommendations) {
			System.out.println(recommendedItem);
		}
	}
	
	private static File getFileName() {
        ClassLoader classLoader = new ProductRecomender().getClass().getClassLoader();
        return new File(classLoader.getResource("dados.csv").getFile());
	}
	
	public FileDataModel getDataModel() throws IOException {
		File file = getFileName();
		return new FileDataModel(file);
	}
}