/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ljodi937.friendfinder;

/**
 *
 * @author jodic
 */
public class Student {
     int studentId;
    int friendIds[];

    public Student(int id, int friends[]) {
        studentId = id;
        friendIds = friends.clone();
    }
}
