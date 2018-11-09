package Characters;

public class Player {
	
	String id;
	String name;
	String fatherName;
	String fatherId;
	String motherName;
	String motherId;
	String spouses[];
	String spousesIds;
	
	public Player(String id, String name, String fatherName, String fatherId, String motherName, String motherId,
			String spouses[], String spousesIds) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.fatherId = fatherId;
		this.motherName = motherName;
		this.motherId = motherId;
		this.spouses = spouses;
		this.spousesIds = spousesIds;
	}
	
	@Override
	public String toString() {
		return this.name + "- pai: " + this.fatherName + " mae: " + this.motherName
				+ "- casado com " + this.spouses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherId() {
		return motherId;
	}

	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}

	public String[] getSpouses() {
		return spouses;
	}

	public void setSpouses(String spouses[]) {
		this.spouses = spouses;
	}

	public String getSpousesIds() {
		return spousesIds;
	}

	public void setSpousesIds(String spousesIds) {
		this.spousesIds = spousesIds;
	}	
}
