/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackiterator;

/**
 *
 * @author kamaj
 */
interface Iterator {
    boolean hasNext();
    Object next();
}

public class StackIterator implements Iterator {
    private ListItem  current;
    private Stack container; // container on tietorakenne, jota iteroidaan
    private int number;
    private boolean hasNextItem = true;

    StackIterator (Stack c) { // konstruktori on "package visible"
        container = c;
        
        number = container.getSize()-1;
        current = container.taulu[number];
    }
    // palautetaan tieto siitä, löytyyko rakenteesta seuraava alkio
    // hmm... palautetaan tieto siitä, osoittaako nykypositio (current) alkiota vai ei.
    public boolean hasNext() {
        if (!hasNextItem)
            return false;
        else
            return true;
    }
    // palautetaan nykyinen (lista-alkio) ja siirretään nykypositiota pykälä eteenpäin
    public ListItem next() {
        
        if(number == 0){
            hasNextItem = false;
        }
        current = container.taulu[number];
            number--;
        return current;
    }

}

