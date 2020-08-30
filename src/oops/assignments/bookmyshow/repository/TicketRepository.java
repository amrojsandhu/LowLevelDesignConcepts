package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.dao.TicketDAO;
import oops.assignments.bookmyshow.objects.Show;
import oops.assignments.bookmyshow.objects.Ticket;
import oops.assignments.bookmyshow.objects.User;

public class TicketRepository extends Repository<TicketDAO, String> {

    private UserRepository userRepository;
    private ShowRepository showRepository;

    public TicketRepository(UserRepository userRepository, ShowRepository showRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    public void save(Ticket ticket) {
        super.save(new TicketDAO(ticket), ticket.getId());
    }

    public Ticket getTicketById(String id) {
        TicketDAO ticketDAO = super.getById(id);
        User user = userRepository.getById(ticketDAO.getAccountId());
        Show show = showRepository.getShowById(ticketDAO.getShowId());
        return new Ticket(id, user, ticketDAO.getBookedOnEpoch(), ticketDAO.getSeat(), show);
    }
}
