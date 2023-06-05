/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ljodi937.friendfinder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jodic
 */
public class TrueFriendFinder {
    static Student[] students = {
            new Student(80, new int[]{53, 4, 22}),
            new Student(22, new int[]{80, 4}),
            new Student(53, new int[]{80, 22}),
            new Student(4, new int[]{22, 53}),
    };

    public static void main(String[] args) {
        HashMap<Integer,Integer> friends = new HashMap<>();
        Set<int[]> set = new HashSet<>();
        for (int i=0; i<students.length; i++) {
            for (int j = 0; j < students[i].friendIds.length; j++) {
                for (int m=0; m<students.length; m++) {
                    for (int k = 0; k < students[m].friendIds.length; k++) {
                        if((students[i].friendIds[j]==students[m].studentId)&&students[m].friendIds[k]==students[i].studentId){
                            friends.put(students[i].studentId,students[i].friendIds[j]);
                            if(students[i].studentId<students[i].friendIds[j]){
                                int[] friend1 = {students[i].studentId,students[i].friendIds[j]};
                                set.add(friend1);
                            }
                            else{
                                int[] friend = {students[i].friendIds[j],students[i].studentId};
                                set.add(friend);
                            }
                            }
          
                
                    }
                }
            }
         }
        for (int[] close : set) {
            System.out.println(close[0]+","+close[1]);
        }
        System.out.println(friends);
    }
}