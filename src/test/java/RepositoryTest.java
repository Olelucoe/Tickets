import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Repository;
import ru.netology.Ticket;

public class RepositoryTest {
    Repository repo = new Repository();

    Ticket ticket1 = new Ticket(10, 9000, "DME", "LED", 90);
    Ticket ticket2 = new Ticket(15, 7000, "LED", "KUF", 130);
    Ticket ticket3 = new Ticket(30, 60000, "VKO", "TAH", 600);
    Ticket ticket4 = new Ticket(70, 28000, "SVO", "LHR", 280);
    Ticket ticket5 = new Ticket(58, 14000, "KZN", "TIV", 175);

    @Test
    public void shouldSaveTicket(){
        repo.saveTicket(ticket1);
        repo.saveTicket(ticket2);
        repo.saveTicket(ticket5);

    Ticket[] expected = {ticket1, ticket2, ticket5};
    Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTicketById() {
        repo.saveTicket(ticket1);
        repo.saveTicket(ticket3);
        repo.saveTicket(ticket4);

        repo.removeById(30);

        Ticket[] expected = {ticket1, ticket4};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void showAllTickets() {

        Ticket[] expected = {};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ThrowsNotFoundException() {
        repo.saveTicket(ticket2);
        repo.saveTicket(ticket3);
        repo.saveTicket(ticket4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(773);});
    }
}
