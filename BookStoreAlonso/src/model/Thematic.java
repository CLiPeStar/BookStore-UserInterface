package model;

public enum Thematic {
	Terror(1, "Terror"), Fantasy(2, "Fantasy"), Action(3, "Action"), Adventure(4, "Adventure");

	private int id;
	private String name;

	Thematic(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

}
