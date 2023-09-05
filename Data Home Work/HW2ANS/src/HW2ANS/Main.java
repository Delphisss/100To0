/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW2ANS;

/**
 *
 * @author 0736
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        DynamicArray var = new DynamicArray(2);
        for (int i=0; i<10; i++){
            var.pushBack(i*i + 1);
        }
        var.printStructure();
        System.out.println(var.get(10));
        var.set(10, 555);
        var.remove(10);
        var.printStructure();
}
    
}
