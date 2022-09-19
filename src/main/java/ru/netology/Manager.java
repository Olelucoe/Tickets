package ru.netology;

import java.util.Arrays;

public class Manager {

    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.saveTicket(ticket);
    }

    public Ticket[] findAll() {
        return repo.getTickets();
    }

    public Ticket[] searchBy(String from, String to) { // поиск по двум параметрам (страна вылета, страна прилёта)
        Ticket[] result = new Ticket[0]; // создаём новый массив, изначально он пустой,в нём будем хранить подошедшие запросу tickets
        for (Ticket ticket : repo.getTickets()) { // циклом перебираем товары в репозитории
            if (matches(ticket, from, to)) { // проверяем подходит ли товар с помощью метода matches
                Ticket[] tmp = new Ticket[result.length + 1]; // создаём ещё один массив на единицу больше, чем result
                for (int i = 0; i < result.length; i++) { // копируем всё из result
                    tmp[i] = result[i]; // копируем всё из result
                }
                tmp[tmp.length - 1] = ticket;// "добавляем в конец" массива result новый билет
                result = tmp; // запоминаем текущий массив в качестве результата
            }
        }
        Arrays.sort(result); // сортируем билеты по цене
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true; // если название ticket содержит нужные нам слова, то возвращаем true
            }
        }
        return false;
    }
}
