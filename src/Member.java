import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.HashSet;
import java.io.Serializable;

public class Member implements Serializable{
	//Instance Variables
	private String name;
	private int year;
	private HashSet<Interest> interests;
	private HashSet<Member> potentialMatches;

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
	
	public void AddInterest(String name, int score, Member member)
	{
		Interest interest = new Interest(name, score);
		InterestMap interestmap = new InterestMap<>();
		
		interests.add(interest);
		interestmap.addMemberToInterest(member, interest);
		UpdateMatches(member);
	}
	
	public HashSet ListInterests()
	{
		return interests;
	}
	
	public void UpdateMatches(Member members)
	{
		InterestMap interestmap = new InterestMap<>();
		int compatibilityScore = 0;
		
		
		for (Interest interest : interests) {
			interestmap.getMembersWithInterest(interest);
			potentialMatches.add(members);
		}
		
		for (Member member : potentialMatches) {
			
		}
	}
	
	public HashSet getTopMatches()
	{
		
	}

	//Constructors
	public Member(String name, int year)
	{
		this.name = name;
		this.year = year;
		this.interests = new HashSet<Interest>();
		this.potentialMatches = new HashSet<Member>();
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