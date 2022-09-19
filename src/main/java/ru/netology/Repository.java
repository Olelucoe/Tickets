package ru.netology;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void saveTicket(Ticket ticket){
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }
    public void removeById (int id) {
        if (findById(id) == null) { // если товара с таким id нет, то --
            throw new NotFoundException("Нет билета с таким id для удаления: " + id); // создаём такое исключение
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int CopyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[CopyToIndex] = ticket;
                CopyToIndex++;
            }
        }
        tickets = tmp;
    }
    public Ticket findById(int id){
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) { // если id товара совпадает с искомым
                return ticket; // то возвращаем его
            }
        }
        return null;
    }
    public Ticket[] getTickets(){
        return tickets;
    }
}
