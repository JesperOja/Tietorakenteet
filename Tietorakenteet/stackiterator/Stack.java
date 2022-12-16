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
public class Stack {

        ListItem top; // top näkyy oletuspakkaukseen
        int size;
        ListItem[] taulu = new ListItem[50];

        public Stack() {
                top = null;
                size = 0;
        }
        //  palautetaan pino-iteraattori
        public StackIterator iterator() {
            return new StackIterator(this);
        }
        // muodostetaan uusi alkio ja viedään se huipulle
        public void push(String aData) {
                ListItem newItem = new ListItem(); // luodaan uusi lista-alkio
                newItem.setData(aData);
                newItem.setLink(top); // kytketään uusi alkio aikaisempaan huippualkioon
                top = newItem; // uusi alkio pinon 1:ksi
                taulu[getSize()] = top;
                size++;
        }
        // poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
        public ListItem pop() {
                ListItem takeAway;
                if (top == null) {
                        takeAway = null; // pino on tyhjä
                }
                else
                {
                        taulu[getSize()] = null;
                        size--;
                        takeAway = top;
                        top = top.getLink();
                }
                return takeAway;
        }
        // palautetaan pinottujen alkioiden lukumäärä
        public int getSize() {
                return size;
        }
        // listataan sisältö
        public void printItems() {
                ListItem lPointer = top;
                while (lPointer != null) {
                        System.out.print(lPointer.getData()+", ");
                        lPointer = lPointer.getLink();
                }

        }
}

