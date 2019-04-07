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
public class ASTARRomania {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph romania =new Graph();
        Node Arad = new Node("Arad",366);
        romania.addNode(Arad);
        Node Bucharest = new Node("Bucharest",0);
        romania.addNode(Bucharest);
        Node Craiova = new Node("Craiova",160);
        romania.addNode(Craiova);
        Node Dobreta = new Node("Dobreta",242);
        romania.addNode(Dobreta);
        Node Eforie = new Node("Eforie",161);
        romania.addNode(Eforie);
        Node Fagaras = new Node("Fagaras",178);
        romania.addNode(Fagaras);
        Node Giurgiu = new Node("Giurgiu",77);
        romania.addNode(Giurgiu);
        Node Hirsova = new Node("Hirsova",151);
        romania.addNode(Hirsova);
        Node Iasi = new Node("Iasi",226);
        romania.addNode(Iasi);
        Node Lugoj = new Node("Lugoj",244);
        romania.addNode(Lugoj);
        Node Mehadia = new Node("Mehadia",241);
        romania.addNode(Mehadia);
        Node Neamt = new Node("Neamt",234);
        romania.addNode(Neamt);
        Node Oradea = new Node("Oradea",380);
        romania.addNode(Oradea);
        Node Pitesti = new Node("Pitesti",98);
        romania.addNode(Pitesti);
        Node Rimnicu = new Node("Rimnicu Vilcea",193);
        romania.addNode(Rimnicu);
        Node Sibiu = new Node("Sibiu",253);
        romania.addNode(Sibiu);
        Node Timisoara = new Node("Timisoara",329);
        romania.addNode(Timisoara);
        Node Urziceni = new Node("Urziceni",80);
        romania.addNode(Urziceni);
        Node Vaslui = new Node("Vaslui",199);
        romania.addNode(Vaslui);
        Node Zerind = new Node("Zerind",374);
        romania.addNode(Zerind);
        
        romania.setEdge(Arad, Zerind, 75);
        romania.setEdge(Arad, Timisoara, 118);
        romania.setEdge(Timisoara, Lugoj, 111);
        romania.setEdge(Zerind, Oradea, 71);
        romania.setEdge(Arad, Sibiu, 140);
        romania.setEdge(Lugoj, Mehadia, 70);
        romania.setEdge(Mehadia, Dobreta, 75);
        romania.setEdge(Oradea, Sibiu, 151);
        romania.setEdge(Sibiu, Fagaras, 99);
        romania.setEdge(Sibiu, Rimnicu, 80);
        romania.setEdge(Dobreta, Craiova, 120);
        romania.setEdge(Rimnicu, Pitesti, 97);
        romania.setEdge(Craiova, Pitesti, 138);
        romania.setEdge(Pitesti, Bucharest, 101);
        romania.setEdge(Fagaras, Bucharest, 211);
        romania.setEdge(Giurgiu, Bucharest, 90);
        romania.setEdge(Bucharest, Urziceni, 85);
        romania.setEdge(Urziceni, Hirsova, 98);
        romania.setEdge(Eforie, Hirsova, 86);
        romania.setEdge(Neamt, Iasi, 87);
        romania.setEdge(Iasi, Vaslui, 92);
        romania.setEdge(Vaslui, Urziceni, 142);
        
        //Arad.label="Aradian";
        //Bucharest.label="Bukarest";
        romania.setStart(Arad);
        romania.setGoal(Bucharest);
        romania.showAllNode();
        System.out.println("ASTAR 1");
        romania.aStar();
        //System.out.println("UCS");
        //romania.UCS();
        romania.sol_path();
        
        
        
    }
    
}
