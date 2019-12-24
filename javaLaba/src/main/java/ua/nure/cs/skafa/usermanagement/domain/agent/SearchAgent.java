package ua.nure.cs.skafa.usermanagement.domain.agent;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import ua.nure.cs.skafa.usermanagement.domain.User;
import ua.nure.cs.skafa.usermanagement.domain.db.DaoFactory;
import ua.nure.cs.skafa.usermanagement.domain.db.DatabaseException;
import jade.domain.FIPAException;


import java.util.Collection;

public class SearchAgent extends Agent {
   
	private static final long serialVersionUID = 2305711707908039257L;
	private AID[] aids;
    private SearchGui gui = null;

    @Override
    protected void setup() {
        super.setup();
        System.out.println(getAID().getName() + " started");

        gui = new SearchGui(this);
        gui.setVisible(true);

        DFAgentDescription description = new DFAgentDescription();
        description.setName(getAID());
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setName("JADE-searching");
        serviceDescription.setType("searching");
        description.addServices(serviceDescription);
        try {
            DFService.register(this, description);
        } catch (FIPAException e) {
            e.printStackTrace();
        }

     