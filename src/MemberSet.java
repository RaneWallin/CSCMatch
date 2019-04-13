import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MemberSet implements Serializable {
    private Set<Member> memberSet = new HashSet<Member>();
    private InterestMap<Interest, Member[]> interestMap;

    public MemberSet(InterestMap<Interest, Member[]> interestMap) {
        this.interestMap = interestMap;
    }

    public void addMember(Member member) {
        memberSet.add(member);
    }

    public void removeMember(Member member) {
        memberSet.remove(member);
    }

    public Set getAllMembers() {
        return memberSet;
    }

    public Member getMemberByName(String name) {
        Member member = null;

        for(Member myMember: memberSet) {
            if(name == myMember.getName()) member = myMember;
        }

        return member != null ? member : null;
    }

    public Boolean hasMemberByName(String  name) {
        Boolean hasMember = false;
        for(Member member: memberSet) if (name == member.getName()) hasMember = true;
    }

    public InterestMap getInterestMap() {
        return interestMap;
    }

    @Override
    public String toString() {
        return "Printing members";
    }

}
