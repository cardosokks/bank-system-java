package br.com.banco.main;

import br.com.banco.service.AppService;

public class Main {
    public static void main(String[] args) {
        AppService appService = new AppService();
        appService.inicializar();
    }
}
