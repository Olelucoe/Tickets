package ru.netology.tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Manager;
import ru.netology.Repository;
import ru.netology.Ticket;

public class ManagerTest {

    Repository repo = new Repository();
    Manager manager  = new Manager(repo);

    Ticket ticket1 = new Ticket(10, 9000, "DME", "LED", 90);
    Ticket ticket2 = new Ticket(15, 7000, "LED", "KUF", 130);
    Ticket ticket3 = new Ticket(30, 60000, "VKO", "TAH", 600);
    Ticket ticket4 = new Ticket(70, 28000, "SVO", "LHR", 280);
    Ticket ticket5 = new Ticket(58, 14000, "KZN", "TIV", 175);
    Ticket ticket6 = new Ticket(59, 17000, "KZN", "TIV", 155);

    @Test
    public void shouldSearchTicket(){
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket5);
        manager.add(ticket2);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("VKO", "TAH");
        Ticket[] expected ={ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchInEmptyRepo() {

        Ticket[] actual = manager.searchBy("DME", "KUF");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchNonExistTicket(){
        manager.add(ticket5);
        manager.add(ticket2);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("AAA", "BBB");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchTwoTicket(){
        manager.add(ticket6);
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("KZN", "TIV");
        Ticket[] expected = {ticket5,ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showFindAll() {
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket5);
        manager.add(ticket2);
        manager.add(ticket4);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = manager.findAll();
    }

    @Test
    public void shouldTicketWhenOneParamNotMatch(){
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("DME", "LUX");
        Ticket[] expected ={};

        Assertions.assertArrayEquals(expected, actual);
    }
}
