/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarromania;

/**
 *
 * @author fawwaz
 */
public class Node {
    public String label;
    public int heuristic;
    public int distFromSource =0 ;
    public boolean visited;
    public Node parent = null;
    
    Node(String label,int h){
        this.label=label;
        this.heuristic=h;
        this.visited = false;
    }
    
    public int f(){
        return this.distFromSource + this.heuristic;
    }
    
    public boolean isEqual(Node k){
        return this.label.equals(k.label);
    }
    
}
