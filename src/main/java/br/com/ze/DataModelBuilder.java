package br.com.ze;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;

public class DataModelBuilder {

	public FileDataModel getProductsModel() throws IOException {
		return new FileDataModel(getFileName("dados.csv"));
	}

	public FileDataModel getCoursesModel() throws IOException {
		return new FileDataModel(getFileName("cursos.csv"));
	}
	
	private File getFileName(String fileName) {
        ClassLoader classLoader = new ProductRecomender().getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
	}
}
