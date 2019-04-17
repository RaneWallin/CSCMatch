import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Member implements Serializable{
	//Instance Variables
	private String name;
	private int year;
	private HashSet<Interest> interests;
	private Map<Member, Integer> potentialMatches;
	private MemberSet members;

	//Constructors
	public Member(String name, int year, MemberSet members)
	{
		this.name = name;
		this.year = year;
		this.members = members;
		this.interests = new HashSet<>();
		this.potentialMatches = new HashMap<>();
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", year=" + year + ", interest=" + interests + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public void addInterest(Interest interest)
	{
		//Interest interest = new Interest(name, score);
		InterestMap interestMap = members.getInterestMap();
		
		interests.add(interest);
		interestMap.addMemberToInterest(this, interest);

		updateMatches(interest);
	}
	
	public HashSet listInterests()
	{
		return interests;
	}
	
	public void updateMatches(Interest interest)
	{
		int score = 0;
//		for (Member member : members) {
//			score = calcMatchScore(member);
//			potentialMatches.put(member, score);
//		}
		
	}

	public void addPotentialMatch(Member member) {
		potentialMatches.put(member, calcMatchScore(member));
	}

	private int calcMatchScore(Member member) {
		return 1;
	}
	
	public HashSet getTopMatches()
	{
		return new HashSet();
	}
	
	//Getters and Setters
	public String getName()
	{
		return name;
	}
	
	public void setName()
	{
		this.name = name;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear()
	{
		this.year = year;
	}

	
}