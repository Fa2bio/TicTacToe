package com.github.Fa2bio.TicTacToe.model;

public class Field {
	
	//position x
	private int line;
	//position y
	private int column;
	
	private String charac;
	//Has the field been marked?
	private boolean marcked = false;

	//Class constructor
	Field(int line, int column, String carac){
		this.line = line;
		this.column = column;
		this.charac = carac;
	}
	
	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String getCharac() {
		return charac;
	}

	public boolean isMarcked() {
		return marcked;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setCharac(String charac) {
		this.charac = charac;
	}

	public void setMarcked(boolean marcked) {
		this.marcked = marcked;
	}
	
	void restart() {
		this.marcked = false;
	}
	public String toString() {
		StringBuilder sr = new StringBuilder();
		sr.append(charac);
		return sr.toString();
	}

}
