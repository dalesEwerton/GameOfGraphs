package Characters;

public class Character {
	
	Integer id;
	String name;
	String fatherName;
	String fatherId;
	String motherName;
	String motherId;
	String spouses;
	String spousesIds;
	
	public Character(Integer id, String name, String fatherName, String fatherId, String motherName, String motherId,
			String spouses, String spousesIds) {
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
}