/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/**
 *
 * @author Nelson Matsinhe
 */


@Service
public class TarefaDesalocarMaquinas {

    private final MaquinaDAO maquinaDAO;

    public TarefaDesalocarMaquinas(MaquinaDAO maquinaDAO) {
        this.maquinaDAO = maquinaDAO;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Executa à meia-noite todos os dias
    public void desalocarDiariamente() {
        maquinaDAO.desalocarTodasAsMaquinas();
    }
}
