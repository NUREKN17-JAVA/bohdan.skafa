package ua.nure.cs.skafa.usermanagement.domain.agent;

import javax.swing.*;

import jade.tools.sniffer.Message;
import ua.nure.cs.skafa.usermanagement.domain.gui.UserTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author mak
 */
public class SearchGui extends JFrame {

    private SearchAgent agent;

    private JPanel contentPanel;

    private JPanel tablePanel;

    private JTable table;

    /**
     * @param agent
     */
    public SearchGui(SearchAgent agent) {
        this.agent = agent;
        initialize();
    }

    private void initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Searcher");
        this.setContentPane(getContentPanel());
    }

    /**
     * @return
     */
    private JPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(getSearchPanel(), BorderLayout.NORTH);
            contentPanel.add(new JScrollPane(getTablePanel()), BorderLayout.CENTER);
        }
        return contentPanel;
    }

    /**
     * @return
     */
    private JPanel getTablePanel() {
        if (tablePanel == null) {
            tablePanel = new JPanel(new BorderLayout());
            tablePanel.add(getTable(), BorderLayout.CENTER);
        }
        return tablePanel;
    }

    /**
     * @return
     */
    private JTable getTable() {
        if (table == null) {
            table = new JTable(new UserTableModel(new LinkedList()));
        }
        return table;
    }

    /**
     * @return
     */
    private JPanel getSearchPanel() {
        return new SearchPanel(agent);
    }

    public static void main(String[] args) {
        SearchGui gui = new SearchGui(null);
        gui.setVisible(true);
    }

    /**
     * @author mak
     */
    class SearchPanel extends JPanel implements ActionListener {
        //        protected JFrame parent;
        SearchAgent agent;

        private JPanel buttonPanel;

        private JPanel fieldPanel;

        private JButton cancelButton;

        private JButton searchButton;

        private JTextField firstNameField;

        private JTextField dateOfBirthField;

        private JTextField lastNameField;


        public SearchPanel(SearchAgent agent) {
            this.agent = agent;
            initialize();
        }

        private void initialize() {
            this.setName("addPanel"); //$NON-NLS-1$
            this.setLayout(new BorderLayout());
            this.add(getFieldPanel(), BorderLayout.NORTH);

        }

        private JPanel getButtonPanel() {
            if (buttonPanel == null) {
                buttonPanel = new JPanel();
                buttonPanel.add(getSearchButton(), null);
                buttonPanel.add(getCancelButton(), null);
            }
            return buttonPanel;
        }

        private JButton getCancelButton() {
            if (cancelButton == null) {
                cancelButton = new JButton();
                cancelButton.setText("AddPanel.cancel"); //$NON-NLS-1$
                cancelButton.setName("cancelButton"); //$NON-NLS-1$
                cancelButton.setActionCommand("cancel"); //$NON-NLS-1$
                cancelButton.addActionListener(this);
            }
            return cancelButton;
        }

        private JButton getSearchButton() {
            if (searchButton == null) {
                searchButton = new JButton();
                searchButton.setText("Search"); //$NON-NLS-1$
                searchButton.setName("okButton"); //$NON-NLS-1$
                searchButton.setActionCommand("ok"); //$NON-NLS-1$
                searchButton.addActionListener(this);
           }