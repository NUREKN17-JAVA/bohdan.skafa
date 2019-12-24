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

        addBehaviour(new TickerBehaviour(this, 60000)  {
            @Override
            protected void onTick() {
                DFAgentDescription agentDescription = new DFAgentDescription();
                ServiceDescription serviceDescription = new ServiceDescription();
                serviceDescription.setType("searching");
                agentDescription.addServices(serviceDescription);
                try {
                    DFAgentDescription[] descriptions = DFService.search(myAgent, agentDescription);
                    aids = new AID[descriptions.length];
                    for (int i = 0; i < descriptions.length; i++) {
                        DFAgentDescription description1 = descriptions[i];
                        aids[i] = description1.getName();
                    }
                } catch (FIPAException e) {
                    e.printStackTrace();
                }
            }
        });

        addBehaviour(new RequestServer());
    }

    
    @Override
    protected void takeDown() {
        System.out.println(getAID().getName() + " finished");
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {
            e.printStackTrace();
        }
    }

    public void search(String firstName, String lastName) throws SearchException {
        try {
            Collection<User> users = DaoFactory.getInstance().getUserDao().findAll(firstName, lastName);
            if (users.size() > 0) {
                showUsers(users);
            } else {
                addBehaviour(new SearchRequestBehavior(aids, firstName, lastName));
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        gui.setVisible(false);
        gui.dispose();
        super.takeDown();
    }

    void showUsers(Collection<User> users) {
        gui.addUsers(users);
    }
}