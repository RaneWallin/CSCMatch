/*
 * InterestMap.java
 *
 * This class creates an InterestMap collect that stores a Map of Interest => Members
 */

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class InterestMap<K,V> implements Serializable
{
    private Map<K,List<V>> interestMap;

    public InterestMap() {
        interestMap = new HashMap<K, List<V>>();
    }

    // add a member to an interest
    public void addMemberToInterest(V member, K interest) {
        List members = interestMap.get(interest);

        // if the interest doesn't have members
        // create an ArrayList
        if(members == null) {
            members = new ArrayList<V>();
        }

        // Add member to the list
        members.add(member);

        // put the interest on the map
        interestMap.put(interest, members);
    }

    // remove member from interest
    public void removeMemberFromInterest(V member, K interest) throws Exception {
        // get the list of members with the interest
        List<V> members = interestMap.get(interest);
        try {
            // try to remove the member from the list
            members.remove(member);
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        // add updated member list back to interestMap
        interestMap.put(interest, members);
    }

    // Get members with interest
    public V[] getMembersWithInterest(K interest) {
        return (V[]) ((List<V>)interestMap.get(interest)).toArray();
    }

    // Get a Set with all the interests
    public Set<K> getAllInterests() {
        return interestMap.keySet();
    }
}
