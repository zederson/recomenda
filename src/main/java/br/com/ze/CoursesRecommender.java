package br.com.ze;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class CoursesRecommender {

	public static void main(String[] args) throws IOException, TasteException {
		FileDataModel courses = new DataModelBuilder().getCoursesModel();
		Recommender recommender = new MyRecommenderBuilder().buildRecommender(courses);

		List<RecommendedItem> recommendations = recommender.recommend(15, 6);
		for (RecommendedItem recommendedItem : recommendations) {
			System.out.println(recommendedItem);
		}
	}
}
