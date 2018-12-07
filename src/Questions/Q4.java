package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jgrapht.Graph;

import Graph.Actions;

public class Q4 {

	public static Actions a = new Actions();

	public static void main(String[] args) {
		Graph gotGraph = a.getGotGraph();
		Set<String> plays = a.getGotVertex().keySet();
		getImportantPlayers(gotGraph, plays);
	}
	
	private static void getImportantPlayers(Graph graph, Set<String> players) {
		
		for(String play: players) {
			if(a.clusterPlayerScore(play) > 0.013) {
				System.out.println("Personagem " + play + " - Score: " + a.clusterPlayerScore(play));
				String title = "Q4 - " + play;
				Graph sub = a.getAVertexSubgraph(play, title);
				a.createGraphImage(sub, title);
			}
		}
			
	}

}
