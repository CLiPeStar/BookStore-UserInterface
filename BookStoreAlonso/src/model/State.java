package model;

public enum State {
	Reissue(1,"Reissue"),Novelty(2,"Novelty");
	
	private int id;
	private String name;
	
	State(int id, String name) {
		this.id=id;
		this.name=name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}
	
}
