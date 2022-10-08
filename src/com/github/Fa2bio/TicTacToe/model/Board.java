package com.github.Fa2bio.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int lines = 3;
	private final int columns = 3;
	
	private List<Field> fields = new ArrayList<Field>();
	public Board(){		
		generateFields();

	}
	private void generateFields() {
		for (int line = 0; line < lines; line++) {
			for (int column = 0; column < columns; column++) {
				fields.add(new Field(line,column,"_"));
			}
		}
	}
	
	public void toMark(int line, int column, Player player) {
		for (Field field : fields) {
			if(field.getLine() == line && field.getColumn() == column && !field.isMarcked()) {
				field.setMarcked(true);
				player.addNumOfMoves();
				field.setCharac(player.getCharac());
			}
		}
	}
	
	public boolean achievedGoal(Player player) {
		boolean goal=false;
		int acumulator;
		int acumulatorD2=0;
		int i=0;
		Field f;
		
		for (int line = 0; line < lines; line++) {
			acumulator=0;
			for (int column = 0; column < columns; column++) {
				f = fields.get(i);
				if(f.getCharac().equalsIgnoreCase(player.getCharac())) 	acumulator++;
				else acumulator=0;
				i++;
			}
			if(acumulator==3) {
				player.setWinner(true);
				return true;
			}else goal = false;
		}
		
		for (int column = 0; column < columns; column++) {
			i=column;
			acumulator=0;
			for (int line = 0; line < lines; line++) {
				f = fields.get(i);
				if(f.getCharac().equalsIgnoreCase(player.getCharac())) 	acumulator++;
				
				i+=3;
			}
			if(acumulator==3) {
				player.setWinner(true);
				return true;
			}else goal = false;
			
		}
		
		i=0;
		acumulator=0;
		for (int column = 0; column < columns; column++) {			
			for (int line = 0; line < lines; line++) {
				if(line==column) {
					f = fields.get(i);
					if(f.getCharac().equalsIgnoreCase(player.getCharac())) acumulator++;
				}
				if((line==0&&column==2)||(line==1&&column==1)||(line==2&&column==0)) {
					f = fields.get(i);
					if(f.getCharac().equalsIgnoreCase(player.getCharac())) acumulatorD2++;
				}
				i++;
			}
			if(acumulator==3||acumulatorD2==3) {
				player.setWinner(true);
				return true;
			}else goal = false;
			
		}

		return goal;
	}
	
	public void restart() {
		fields.stream().forEach(c -> c.restart());
		fields.stream().forEach(c -> c.setCharac("_"));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int column = 0; column < columns; column++) {
			sb.append(" ");
			sb.append(column);
			sb.append(" ");
		}
		sb.append("\n");
		
		int i = 0;
		
		for (int line = 0; line < lines; line++) {
			sb.append(line);
			sb.append(" ");
			for (int column = 0; column < columns; column++) {
				sb.append(" ");
				sb.append(fields.get(i));
				sb.append(" ");
				i++;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
