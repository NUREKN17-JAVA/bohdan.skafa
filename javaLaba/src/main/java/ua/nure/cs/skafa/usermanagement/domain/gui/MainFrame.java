package ua.nure.cs.skafa.usermanagement.domain.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.nure.cs.skafa.usermanagement.domain.User;
import ua.nure.cs.skafa.usermanagement.domain.db.DaoFactory;
import ua.nure.cs.skafa.usermanagement.domain.db.UserDao;
import ua.nure.cs.skafa.usermanagement.util.Messages;

public class MainFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;
	private JPanel contentPanel;
	private JPanel browsePanel;
	private AddPanel addPanel;
	private EditPanel editPanel;
	private DetailsPanel detailsPanel;
	private UserDao dao;
	
	public MainFrame() {
		super();
		dao = DaoFactory.getInstance().getUserDao();
		initialize();
	}

	public UserDao getDao() {
		return dao;
	}

	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle(Messages.getString("MainFrame.user_management")); //$NON-NLS-1$
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
		((BrowsePanel)browsePanel).initTable();
			return browsePanel;
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}
	
	 private EditPanel getEditPanel() {
	        if (editPanel == null) {
	            editPanel = new EditPanel(this);
	        }
	        return editPanel;
	    }
	
	 public void showEditPanel(User user) {

	    getEditPanel().setUser(user);
        showPanel(getEditPanel());
     }

	public void showAddPanel() {
		showPanel(getAddPanel());
		
	}

	private void showPanel(JPanel panel) {
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
		
	}
	
	public void showBrowsePanel() {
        showPanel(getBrowsePanel());
    }
	
	 public void showDetailsPanel(User user) {
	        getDetailsPanel().setUser(user);
	        showPanel(getDetailsPanel());
	    }
	
	    private DetailsPanel getDetailsPanel() {
	        if (detailsPanel == null) {
	            detailsPanel = new DetailsPanel(this);
	        }
	        return detailsPanel;
	    }

	private AddPanel getAddPanel() {
		if (addPanel == null) {
			addPanel = new AddPanel(this);
		}
		return addPanel;
	}

}
