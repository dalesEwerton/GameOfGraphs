package Graph;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import Characters.CharsLoadder;
import Characters.Player;

public class Actions extends JFrame {
	
	private mxGraph graph;
	private mxGraphComponent graphComponent;
	private int cordX = 30;
	private int cordY = 30;
	
	public Actions() {
		super("JGraph - Flow");
		initGUI();
	}
	
	private void initGUI() {
		setSize(1280,768);
		setLocationRelativeTo(null);
		graph = new mxGraph();
		graphComponent = new mxGraphComponent(this.graph);
		graphComponent.setPreferredSize(new Dimension(1280, 768));
		getContentPane().add(graphComponent);
		
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		 
		this.loadCharsNodes();
		
		graph.getModel().endUpdate();
	}
	
	private void loadCharsNodes(){
		CharsLoadder chrs = new CharsLoadder();
		chrs.loadChars();
		Player players[] = chrs.getChars();
		Object parent = graph.getDefaultParent();
		
		for (Player c : players) {
			this.graph.insertVertex(parent, c.getId() , c.getName(), 
					this.cordX, this.cordY, 15, 15);
			this.updateCords();
		}
		
	}
	
	private void updateCords() {
		if (this.cordX < 1000 ) {
			this.cordX += 100;
		} else {
			this.cordX = 30;
			this.cordY +=  100;
		}
	}

}
