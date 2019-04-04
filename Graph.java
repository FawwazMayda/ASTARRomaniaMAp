/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarromania;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author fawwaz
 */
public class Graph {
    public Node start,end;
    public ArrayList<Node> vertices = new ArrayList<>();
    public int [][] adj_mat;
    int size;
    
    public void setStart(Node s){
        this.start=s;
    }
    
    public void setGoal(Node s){
        this.end=s;
    }
    public void addNode(Node s){
        this.vertices.add(s);
    }
    public void setEdge(Node src,Node des,int weight){
  
            if(adj_mat== null) {
                size=this.vertices.size();
                adj_mat = new int[size][size];
            }
            int startIndex = this.vertices.indexOf(src);
            int desIndex = this.vertices.indexOf(des);
            adj_mat[startIndex][desIndex] = weight;
            adj_mat[desIndex][startIndex] = weight;
        
    }
    public void showAllNode(){
        Iterator it = this.vertices.iterator();
        System.out.println("Node are: ");
        while(it.hasNext()){
            Node p= (Node) it.next();
            System.out.println(p.label+" : "+p.heuristic);
        }
        
    }
    
    
    public Node selectBestNode(ArrayList<Node> openList){
        Node best = openList.get(0);
        for(Node p : openList){
            if(p.f() < best.f()){
                best = p;
            }
        }
        return best;
    }
    
    public ArrayList<Node> getAllNeighbor(Node parent){
        ArrayList<Node> res = new ArrayList<>();
        int index = this.vertices.indexOf(parent);
        for(int i=0;i<this.size;i++){
            if(this.adj_mat[index][i] !=0){
                res.add(this.vertices.get(i));
            }
        }
        return res;
    }
    public void aStar(){
        ArrayList<Node> open = new ArrayList<>();
        ArrayList<Node> close = new ArrayList<>();
        Node current;
        Node before;
        int tentative_distSource;
        int currentIndex;
        int neighborIndex;
        open.add(this.start);
        System.out.println("Path Taken:");
        while(!open.isEmpty()){
            current = this.selectBestNode(open);
            System.out.print(current.label+" -> ");
            if(current.isEqual(this.end)){
                break;
            }
            open.remove(current);
            close.add(current);
            currentIndex = this.vertices.indexOf(current);
            for(Node neighbor : this.getAllNeighbor(current)){
                if(close.contains(neighbor)){
                    continue;
                }
                neighborIndex = this.vertices.indexOf(neighbor);
                tentative_distSource = current.distFromSource + this.adj_mat[currentIndex][neighborIndex];
                
                if(!open.contains(neighbor)){
                    open.add(neighbor);
                } else if(tentative_distSource >= neighbor.distFromSource) {
                    continue;
                }
                
                neighbor.distFromSource = tentative_distSource;
                neighbor.parent =  current;
            }
        }
        System.out.println("Complete");
       
    }
    
    public void sol_path(){
        System.out.println("Sol Path: ");
        Node p = this.end;
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Integer> path_index = new ArrayList<>();
        while(p!=null){
            path.add(0, p);
            path_index.add(0, this.vertices.indexOf(p));
            p = p.parent;
        }
        int sum = 0;
        int cost;
        int id1,id2;
        for(int i=0; i<path_index.size()-1;i++){
            id1 = (int) path_index.get(i);
            id2 = (int) path_index.get(i+1);
            cost = this.adj_mat[id1][id2];
            sum +=cost;
            System.out.print(path.get(i).label+" ["+cost+"]-> ");
        }
        System.out.println(path.get(path.size()-1).label);
        System.out.println("Path Cost: "+sum);
    }
    
    
}
