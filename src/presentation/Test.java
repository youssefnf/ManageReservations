/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entities.Categorie;
import entities.Chambre;
import entities.Client;
import services.CategorieService;
import services.ChambreService;
import services.ClientService;

/**
 *
 * @author ep
 */
public class Test {

    public static void main(String[] args) {
        ClientService cs=new ClientService();
        //CategorieService cats=new CategorieService();
        ChambreService chs=new ChambreService();
     //  cs.create(new Client("Kamali","Kamal","0444444444","alaoui@gmail.com"));
        
        for(Client c:cs.findAll()){
            System.out.println(c);
        }
       // for(Categorie cat:cats.findAll()){
            //System.out.println(cat);
        //}
        for(Chambre ch:chs.findAll()){
            System.out.println(ch);
        }
    }
}
