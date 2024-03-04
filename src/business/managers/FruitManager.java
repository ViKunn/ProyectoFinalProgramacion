package business.managers;

import business.entities.fruits.Fruit;
import business.Score;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FruitManager {

	private final HashMap<Integer, Fruit> fruits;

	public FruitManager() {
		fruits = new HashMap<>();

		fruits.put(1, new Fruit("Bananas", loadImage("res/images/fruits/banana.png"), new Score(30)));  // bananas
		fruits.put(2, new Fruit("Uva", loadImage("res/images/fruits/grape.png"), new Score(40)));  // uvas
		fruits.put(3, new Fruit("Exam", loadImage("res/images/fruits/Exams/Exam.png"), new Score(20)));  // uvas

	}

	public BufferedImage loadImage(String imagePath) {
		try {
			File file = new File(imagePath);
			return ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException("Error al cargar la imagen: " + e.getMessage());
		}
	}

	public Fruit getFruit(int fruitNumber) {
		return fruits.get(fruitNumber);
	}

}