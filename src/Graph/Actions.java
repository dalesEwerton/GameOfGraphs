package Graph;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class Actions extends JFrame {
	
	private mxGraph graph;
	private mxGraphComponent graphComponent;
	
	public Actions() {
		super("JGraph - Flow");
		initGUI();
	}
	
	private void initGUI() {
		setSize(800,600);
		setLocationRelativeTo(null);
		graph = new mxGraph();
		graphComponent = new mxGraphComponent(this.graph);
		graphComponent.setPreferredSize(new Dimension(400, 400));
		getContentPane().add(graphComponent);
		
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		Object g = graph.insertVertex(parent, null, "TEST", 30, 80, 100, 50);
		graph.insertVertex(g, null, "TEST2", 40, 80, 100, 50);
		 
		
		graph.getModel().endUpdate();
	}

}
