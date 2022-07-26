package com.board.domain;

public class WaterTestDTO {
	//물생활 테스트를 위한 WaterTestDTO
	private int fishbowl;
	private int percolation;
	private int waterChange;
	private int nutrients;
	private int medicine;
	private int floor;
	private int ph;
	private int food;
	private int quality;
	private int reaction;
	public int getFishbowl() {
		return fishbowl;
	}
	public void setFishbowl(int fishbowl) {
		this.fishbowl = fishbowl;
	}
	public int getPercolation() {
		return percolation;
	}
	public void setPercolation(int percolation) {
		this.percolation = percolation;
	}
	public int getWaterChange() {
		return waterChange;
	}
	public void setWaterChange(int waterChange) {
		this.waterChange = waterChange;
	}
	public int getNutrients() {
		return nutrients;
	}
	public void setNutrients(int nutrients) {
		this.nutrients = nutrients;
	}
	public int getMedicine() {
		return medicine;
	}
	public void setMedicine(int medicine) {
		this.medicine = medicine;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getReaction() {
		return reaction;
	}
	public void setReaction(int reaction) {
		this.reaction = reaction;
	}
	@Override
	public String toString() {
		return "waterTestDTO [fishbowl=" + fishbowl + ", percolation=" + percolation + ", waterChange=" + waterChange
				+ ", nutrients=" + nutrients + ", medicine=" + medicine + ", floor=" + floor + ", ph=" + ph + ", food="
				+ food + ", quality=" + quality + ", reaction=" + reaction + "]";
	} 
	
	
}
