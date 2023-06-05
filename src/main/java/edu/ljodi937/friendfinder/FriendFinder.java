/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ljodi937.friendfinder;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jodic
 */
public class FriendFinder {
     static Student[] students = {
            new Student(80, new int[]{53, 4, 22}),
            new Student(22, new int[]{80, 4}),
            new Student(53, new int[]{80, 22}),
            new Student(4, new int[]{22, 53}),
    };

    public static void main(String[] args) {
        HashMap<Integer,HashSet<Integer>> friends = new HashMap<>();
        Set<int[]> output = new HashSet<>();
         for (Student student : students) {
             Set<Integer> relationship = new HashSet<>();
             for (int j = 0; j < student.friendIds.length; j++) {
                relationship.add(student.friendIds[j]);
             }
             friends.put(student.studentId, (HashSet<Integer>)relationship);
         }
       for (Map.Entry<Integer, HashSet<Integer>> entry : friends.entrySet()){
           for(Integer friend: entry.getValue()){
              if(friends.get(friend).contains(entry.getKey())){
                  if(friend<entry.getKey()){
                      int[] friendship = {friend,entry.getKey()};
                      output.add(friendship);
                  }
                  else{
                      int[] friendship = {entry.getKey(),friend};
                      output.add(friendship);
                  }
              }
           }
       }       
         Set<int[]> closefriends= new HashSet<>();
         for (Iterator<int[]> it = output.iterator(); it.hasNext();) {
             int[] friend= it.next();
             boolean isFound = false;
             for(int[] search: closefriends){
                 if(search[0]==friend[0]&&search[1]==friend[1])
                     isFound = true;
             }
             if(!isFound)
             closefriends.add(new int[]{friend[0], friend[1]});
             }
         
        
         
         for (int[] close : closefriends) {
             System.out.println("CloseFriends:"+close[0]+","+close[1]);
         }
    }
}

/*
from friendship
CloseFriends:53,80
CloseFriends:53,80
CloseFriends:4,22
CloseFriends:4,22
CloseFriends:22,80
CloseFriends:22,80
*/
/*
print from output
CloseFriends:4,22
CloseFriends:22,80
CloseFriends:53,80
CloseFriends:4,22
CloseFriends:53,80
CloseFriends:22,80
*/