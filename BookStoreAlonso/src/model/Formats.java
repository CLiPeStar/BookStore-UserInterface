package model;

public enum Formats {
	Board(1, "Board"), Rustic(2, "Rustic"), Stapled(3, "Stapled"), Spiral(4, "Spiral");

	private int id;
	private String name;
	
	Formats(int id, String name) {
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
