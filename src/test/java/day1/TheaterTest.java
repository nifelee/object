package day1;

import org.junit.Test;

public class TheaterTest {

    @Test
    public void enter() {
        Theater theater = new Theater(100L);
        Audience audience1 = new Audience(0L);
        Audience audience2 = new Audience(50L);
        TicketOffice ticketOffice = new TicketOffice(0L);
        TicketSeller seller = new TicketSeller();

        theater.setTicketOffices(ticketOffice);
        theater.setTicket(ticketOffice, 10L);
        theater.setInvitation(audience1);

        seller.setTicketOffice(ticketOffice);

        audience1.buyTicket(seller);
        audience2.buyTicket(seller);

        boolean isOk1 = theater.enter(audience1);
        boolean isOk2 = theater.enter(audience2);

        System.err.println("isOk1 : " + isOk1);
        System.err.println("isOk2 : " + isOk2);
    }

}
