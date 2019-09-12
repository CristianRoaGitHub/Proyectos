/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.ResizeEvent;

/**
 *
 * @author croa
 */
@Named(value = "mainViewController")
@RequestScoped
public class MainViewController {

    /**
     * Creates a new instance of MainViewController
     * https://www.safaribooksonline.com/videos/mastering-primefaces
     * https://www.safaribooksonline.com
     * safari2018$
     */
    
    private String selectionType;
    private List<Carro> automobiles = new ArrayList<>();
    
    public String getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(String selectionType) {
        this.selectionType = selectionType;
    }

    public List<Carro> getAutomobiles() {
        Carro car1 = new Carro();
        car1.setMarca("Mazda");
        car1.setModelo("1981");
        //car1.setDescripcion("Este es un carro bueno");
        Carro car2 = new Carro();
        car2.setMarca("Kia");
        car2.setModelo("1990");
        //car2.setDescripcion("Este es un carro Excelente");
        Carro car3 = new Carro();
        car3.setMarca("Ferrari");
        car3.setModelo("2000");
        //car3.setDescripcion("Este es un carro Super Excelente");
        automobiles.add(car1);
        automobiles.add(car2);
        automobiles.add(car3);
        return automobiles;
    }

    public void setAutomobiles(List<Carro> automobiles) {
        this.automobiles = automobiles;
    }
    
    
        
    public MainViewController() {
    }
    
    
    
    
    public  void  layourResizeEvent(ResizeEvent e){
        System.out.println("valor " +e.getComponent());
    }
    
    public String navigateCar1(){
        selectionType ="carro_uno";
        return "automobile";
    }
    
    public String navigateCar2(){
        selectionType ="carro_dos";
        return "automobile";
    }
    public String navigateCar3(){
        selectionType ="carro_tres";
        return "automobile";
    }
    
    
}
