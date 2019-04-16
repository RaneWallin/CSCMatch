import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MemberSet implements Serializable {
    private Set<Member> memberSet = new HashSet<Member>();
    private InterestMap<Interest, Member[]> interestMap;

    public MemberSet(InterestMap<Interest, Member[]> interestMap) {
        this.interestMap = interestMap;
    }

    // TODO - add error handling
    public void addMember(Member member) {
        memberSet.add(member);
    }

    // TODO - add error handling
    public void removeMember(Member member) {
        memberSet.remove(member);
    }

    public Set getAllMembers() {
        return memberSet;
    }

    // Looks for a Member in the Member set using their name and
    // returns the Member. Returns null if Member does not exist
    public Member getMemberByName(String name) {
        Member member = null;

        for(Member myMember: memberSet) {
            if(name == myMember.getName()) member = myMember;
        }

        return member != null ? member : null;
    }

    // Checks if Member is part of MemberSet
    public Boolean hasMemberByName(String  name) {
        Boolean hasMember = false;
        for(Member member: memberSet) if (name == member.getName()) hasMember = true;

        return hasMember;
    }

    public InterestMap getInterestMap() {
        return interestMap;
    }

    @Override
    public String toString() {
        StringBuilder members = new StringBuilder();
        for(Member member: memberSet) {
            members.append(member.toString());
        }

        return members.toString();
    }

}