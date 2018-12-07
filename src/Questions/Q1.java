package Questions;

import java.util.HashMap;
import java.util.Set;

import org.jgrapht.Graph;

import Graph.Actions;
import Graph.Main;

public class Q1 {
	public static Actions a = new Actions();
	
	public static void main(String[] args) {
		Graph gotGraph = a.getGotGraph();
		Set<String> plays = a.getGotVertex().keySet();
		common(gotGraph, plays);
	}
	
	private static void common(Graph graph, Set<String> plays) {
		
		int graphSize = graph.vertexSet().size();
		int bigInhierance = 0;
		String bigPlayer = "";
		
		for (String player : plays) {
			Graph playerTree = a.getAVertexSubgraph(player, "SKj");
			if (playerTree.vertexSet().size() > bigInhierance) {
				bigInhierance = playerTree.vertexSet().size();
				bigPlayer = player;
			}
		}
		
		System.out.println( "Questão 1 - O personagem a partir do qual mais alcança personagens é " +
		 bigPlayer + ". Ele alcança um total de " + bigInhierance + " personagens.");
		
		String title = "Questao 1";
		
		Graph response = a.getAVertexSubgraph(bigPlayer, title);
		a.createGraphImage(response, title + " - " + bigPlayer);
	}

}
