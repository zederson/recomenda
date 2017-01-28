package br.com.ze;

import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class ProductRecomender {

	public static void main(String[] args) throws Exception {
		FileDataModel produtos = new DataModelBuilder().getProductsModel();
		Recommender recommender = new MyRecommenderBuilder().buildRecommender(produtos);

		List<RecommendedItem> recommendations = recommender.recommend(2, 3);
		for (RecommendedItem recommendedItem : recommendations) {
			System.out.println(recommendedItem);
		}
	}
}