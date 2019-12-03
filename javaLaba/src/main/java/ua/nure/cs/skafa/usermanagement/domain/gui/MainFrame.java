package ua.nure.cs.skafa.usermanagement.domain.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;
	private JPanel contentPanel;
	private JPanel browsePanel;
	
	public MainFrame() {
		super();
		initialize();
	}

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Управление пользователями");
		this.setContentPane(getContentPanel());
	}

	private JPanel getContentPanel() {
		if (contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
		}
		return contentPanel;
	}
	
	private JPanel getBrowsePanel() {
		if (browsePanel == null) {
			browsePanel = new BrowsePanel(this);
		}
		return browsePanel;
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

	public void showAddPanel() {
		showPanel(getAddPanel());
		
	}

	private void showPanel(JPanel panel) {
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
		
	}

	private AddPanel getAddPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
