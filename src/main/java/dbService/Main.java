package dbService;

import client.ClientService;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        System.out.println(clientService.listAll());
    }
}
