package Questions;

import java.util.ArrayList;
import java.util.Set;

import org.jgrapht.Graph;

import Graph.Actions;

public class Q3 {
	
	public static Actions a = new Actions();
	
	public static void main(String[] args) {
		Graph gotGraph = a.getGotGraph();
		Set<String> plays = a.getGotVertex().keySet();
		topClusters(gotGraph, plays);
	}
	
	private static void topClusters(Graph graph, Set<String> plays) {
		
		int graphSize = graph.vertexSet().size();
		ArrayList<Graph> biggestPlayersGraphs = new ArrayList<>();
		ArrayList<String> biggestPlayersNames = new ArrayList<>();
		
		
		for (String player : plays) {
			Graph playerTree = a.getAVertexSubgraph(player, "");
			if(playerTree.vertexSet().size() > 34) {
				biggestPlayersGraphs.add(playerTree);
				biggestPlayersNames.add(player);
			}
		}
		
		for( int i = 0 ; i < biggestPlayersGraphs.size(); i++) {
			String title = "Questao 3 - Panelinha " + (i+1) + " - Lider: " + biggestPlayersNames.get(i);
			a.createGraphImage(biggestPlayersGraphs.get(i), title);
			System.out.println(title);
			System.out.println(biggestPlayersGraphs.get(i).toString());
		}
	}

}
