package ru.netology.aviaSouls;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {


    @Test

    public void priceComparisonMinusOne() {

        Ticket ticket1 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);
        Ticket ticket2 = new Ticket("Москва", "Сургут", 15_000, 2, 5);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void priceComparisonOne() {

        Ticket ticket1 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);
        Ticket ticket2 = new Ticket("Москва", "Сургут", 15_000, 2, 5);

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void priceOfIdenticalComparison() {

        Ticket ticket1 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);
        Ticket ticket2 = new Ticket("Москва", "Саратов", 5_000, 2, 3);

        int expected = 0;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void sortingTheResponseArray() {
        Ticket ticket1 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);
        Ticket ticket2 = new Ticket("Москва", "Воронеж", 15_000, 2, 3);
        Ticket ticket3 = new Ticket("Воронеж", "Самара", 8_000, 13, 14);
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 24_000, 7, 8);
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 10_000, 22, 23);
        Ticket ticket6 = new Ticket("Москва", "Воронеж", 12_000, 18, 19);
        Ticket ticket7 = new Ticket("Москва", "Воронеж", 30_000, 12, 13);

        AviaSouls price = new AviaSouls();
        price.add(ticket1);
        price.add(ticket2);
        price.add(ticket3);
        price.add(ticket4);
        price.add(ticket5);
        price.add(ticket6);
        price.add(ticket7);
        price.search("Москва", "Воронеж");

        Ticket[] expected = {ticket1, ticket5, ticket6, ticket2, ticket4, ticket7};
        Ticket[] actual = {ticket1, ticket5, ticket6, ticket2, ticket4, ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void flightTimeComparisonMinusOne() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();


        Ticket ticket1 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);
        Ticket ticket2 = new Ticket("Москва", "Сургут", 15_000, 2, 5);

        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void flightTimeComparisonOne() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "Сургут", 15_000, 2, 5);
        Ticket ticket2 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);

        int expected = 1;
        int actual = timeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void comparisonOfTheSameFlightTime() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "Саратов", 5_000, 2, 3);
        Ticket ticket2 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);

        int expected = 0;
        int actual = timeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void sortingAnArrayOfResponsesByFlightTime() {

        TicketTimeComparator time = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "Воронеж", 5_000, 6, 7);
        Ticket ticket2 = new Ticket("Москва", "Воронеж", 15_000, 2, 15);
        Ticket ticket3 = new Ticket("Воронеж", "Самара", 8_000, 13, 14);
        Ticket ticket4 = new Ticket("Москва", "Воронеж", 24_000, 7, 13);
        Ticket ticket5 = new Ticket("Москва", "Воронеж", 10_000, 12, 17);
        Ticket ticket6 = new Ticket("Москва", "Воронеж", 12_000, 17, 24);
        Ticket ticket7 = new Ticket("Москва", "Воронеж", 30_000, 12, 23);

        AviaSouls price = new AviaSouls();
        price.add(ticket1);
        price.add(ticket2);
        price.add(ticket3);
        price.add(ticket4);
        price.add(ticket5);
        price.add(ticket7);
        price.add(ticket6);

        Ticket[] expected = {ticket1, ticket5, ticket4, ticket6, ticket7, ticket2};
        Ticket[] actual = price.searchAndSortBy("Москва", "Воронеж", time);
        Assertions.assertArrayEquals(expected, actual);
    }
}
