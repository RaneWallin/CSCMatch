import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Member implements Serializable{
	//Instance Variables
	private String name;
	private int year;
	private Map<String, Integer> interests;
	private Map<Member, Integer> potentialMatches;
	private MemberSet members;

	//Constructors
	public Member(String name, int year, MemberSet members)
	{
		this.name = name;
		this.year = year;
		this.members = members;
		this.interests = new HashMap<>();
		this.potentialMatches = new HashMap<>();
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", year=" + year + ", interest=" + interests + "]";
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
	
	public void addInterest(int score, String name)
	{
		InterestMap interestMap = members.getInterestMap();
		
		interests.put(name, score);
		interestMap.addMemberToInterest(this, name);

		ArrayList<Member> interestedMembers = (ArrayList<Member>)members.getInterestMap().getMembersWithInterest(name);

		for (Member member : interestedMembers) {
			if (member != this)
				updateMatch(member);
		}
	}
	
	public List listInterests()
	{
		return (List<String>)interests.keySet();
	}
	
	public void updateMatch(Member member)
	{
		int score = 0;
		score = calcMatchScore(member);
		potentialMatches.put(member, score);

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

	public int getMemberInterest(String interest) {
		return interests.get(interest);
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