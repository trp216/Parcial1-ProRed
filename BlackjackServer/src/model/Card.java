package model;

public class Card { //Nota, figure se refiere a el palo

	private String type = "Card";

	private int value;

	private char figure;

	public Card() {}

	public Card(int value, char figure) {
		this.value = value;
		this.figure = figure;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getFigure() {
		return figure;
	}

	public void setFigure(char figure) {
		this.figure = figure;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}
