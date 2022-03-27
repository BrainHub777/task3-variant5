package ru.vsu.cs.buchnev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task {
    public static int task(SimpleLinkedQueue<Double> queue1, SimpleLinkedQueue<Double> queue2, int count) throws Exception {
        if (queue1.count() !=0 && queue2.count() !=0){
            if(queue1.element() < queue2.element()){
                queue1.add(queue1.remove() + queue2.remove());
            }
            else{
                queue2.add(queue1.remove() - queue2.remove());
            }
            count++;
        }
        return count;
    }
    public static int task2(Queue<Double> queue1, Queue<Double> queue2, int count) throws Exception {
            if(queue1.element() < queue2.element()){
                queue1.add(queue1.remove() + queue2.remove());
            }
            else{
                queue2.add(queue1.remove() - queue2.remove());
            }
            count++;
        return count;
    }
    public static SimpleLinkedQueue readLinkedListFromFile(String fileName,int index) throws Exception {
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            String line = null;
            for(int i = 0; i<index;i++) {
                line = scanner.nextLine();
            }
            return stringToLinkedQueue(line);
        }
        catch (FileNotFoundException e) {
            return null;
        }
    }
    public static SimpleLinkedQueue stringToLinkedQueue(String line) throws Exception {
        String[] arr=line.split(" ");
        SimpleLinkedQueue queue = new SimpleLinkedQueue();
        for(int i=0; i< arr.length;i++){
            queue.add(Double.parseDouble(arr[i]));


        }
        return queue;
    }
    public static Queue stringToLinkedQueue1(String line) throws Exception {
        String[] arr=line.split(" ");
        Queue queue = new LinkedList();
        for(int i=0; i< arr.length;i++){
            queue.add(Double.parseDouble(arr[i]));

        }
        return queue;
    }
    public static String stringFromQueue(Queue<Double> queue) throws Exception {
        StringBuilder sb = new StringBuilder();
        for(Double i : queue){
            sb.append(i+" ");
        }
        return sb.toString();
    }
}
