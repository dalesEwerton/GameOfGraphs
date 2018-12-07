package Graph;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.view.mxGraph;

import Characters.CharsLoadder;
import Characters.Player;

public class Actions extends JFrame {
	
	private DefaultDirectedGraph<String, DefaultEdge> gotGraph;
	private mxGraph graph;
	private mxGraphComponent graphComponent;
	private HashMap<Object, Object> graphMap;
	private HashMap<String, Object> gotMap;
	private ArrayList<String> edgeSrc;
	private ArrayList<String> edgeFont;
	private int cordX = 40;
	private int cordY = 40;
	
	public Actions() {
		super("Game of Graphs - JGraph");
		initGraph();
	}
	
	private void initGraph() {
		setSize(1280,768);
		setLocationRelativeTo(null);
		graph    = new mxGraph();
		gotGraph = new DefaultDirectedGraph<>(DefaultEdge.class);
		graphMap = new HashMap<>();
		gotMap   = new HashMap<>();
		edgeSrc  = new ArrayList<>();
		edgeFont = new ArrayList<>();
		graphComponent = new mxGraphComponent(this.graph);
		
		Object parent = graph.getDefaultParent();
		this.loadGraphObject();
		
		
		//Uncoment to load a complet grafic graph
		
		//graphComponent.setPreferredSize(new Dimension(1280, 768));
		//getContentPane().add(graphComponent);
		//graph.getModel().beginUpdate();
		//this.loadGraficGraph();
		//graph.getModel().endUpdate();
	}
	
	private void loadGraphObject(){
		CharsLoadder chrs = new CharsLoadder();
		chrs.loadChars();
		Player players[] = chrs.getChars();
		
		for (Player c : players) {
			Object v = this.gotGraph.addVertex(c.getName());
			this.gotMap.put(c.getName(), v);
		}
		
		for (Player c : players) {
			if (!c.getMotherName().equals("N/A")) {
				try {
					this.gotGraph.addEdge(c.getMotherName(), c.getName());
					this.edgeSrc.add(c.getMotherName());
					this.edgeFont.add(c.getName());
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			if (!c.getFatherName().equals("N/A")) {
				try {
					this.gotGraph.addEdge(c.getFatherName(), c.getName());
					this.edgeSrc.add(c.getFatherName());
					this.edgeFont.add(c.getName());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			for (String spouse : c.getSpouses() ) {
				if (!spouse.equals("N/A")) {
					try {
						this.gotGraph.addEdge(spouse, c.getName());
						this.edgeSrc.add(spouse);
						this.edgeFont.add(c.getName());
						
						this.gotGraph.addEdge(c.getName(), spouse);
						this.edgeSrc.add(c.getName());
						this.edgeFont.add(spouse);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
	
	public AsSubgraph<String, DefaultEdge> getAVertexSubgraph(String startVertex, String title) {
		DepthFirstIterator<String, DefaultEdge> depthFirstIterator 
		  = new DepthFirstIterator<>(this.gotGraph, startVertex);
		
		Set<String> subGraph = new HashSet<>();
		while(depthFirstIterator.hasNext()) {
			subGraph.add(depthFirstIterator.next());
		}
		
		AsSubgraph<String, DefaultEdge> sub = new AsSubgraph<>(gotGraph, subGraph);
		return sub;
	}
	
	
	public DefaultDirectedGraph<String, DefaultEdge> getGotGraph() {
		return this.gotGraph;
	}
	
	public void createGraphImage(Graph g, String name) {
	    
		JGraphXAdapter<String, DefaultEdge> graphAdapter = 
			      new JGraphXAdapter<String, DefaultEdge>(g);
			    mxIGraphLayout layout = new mxCompactTreeLayout(graphAdapter, false);
			    layout.execute(graphAdapter.getDefaultParent());
			   
			    BufferedImage image = 
			      mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, graphComponent.isAntiAlias(), null, graphComponent.getCanvas());
			    File imgFile = new File("output/" + name + ".png");
			    try {
					ImageIO.write(image, "PNG", imgFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
	}
	
	private void loadGraficGraph() {
		Set<String> plays = this.gotMap.keySet();
		Object parent     = this.graph.getDefaultParent();
		
		for (String p : plays) {
			Object v = this.graph.insertVertex(parent, null, p,
					this.cordX, this.cordY, 30, 30);
			this.graphMap.put(p, v);
			this.updateCords();
		}
		
		for (int i = 0 ; i < this.edgeSrc.size(); i++) {
			try {
				this.graph.insertEdge(parent, null, null,
						this.graphMap.get(this.edgeSrc.get(i)),
						this.graphMap.get(this.edgeFont.get(i)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void updateCords() {
		if (this.cordX < 1000 ) {
			this.cordX += 100;
		} else {
			this.cordX = 40;
			this.cordY +=  100;
		}
	}

}
