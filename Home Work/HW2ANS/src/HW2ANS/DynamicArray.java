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
public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
        size = 0;
    }
    
    public void pushBack(int data){
        // FIXED THIS
        if(size<capacity){
            arr[size] = data;
            size++;
        }
        else{
            int[] tmp = new int[capacity*2];
            for(int i = 0; i < size; i++){
                tmp[i] = arr[i];
            }
            tmp[size] = data;
            size++;
            arr = tmp;
            capacity*=2;
        }
    }
    
    public int popBack(){
        // FIXED THIS
        if(this.isEmpty()){
            System.out.println("ERROR");
            return 0;
        }
        else{
        int popBackData = arr[size-1];
        size--;
        return popBackData;
        }
    }

    public int get(int i){
        // FIXED THIS
        int getData;
        if(i >= size || i < 0){
            System.out.println("ERROR");
            return 0;
        }
        else{
            getData = arr[i];
        }
        return getData;
    }
    
    public void set(int i, int value){
        // FIXED THIS
        if(i >= size || i < 0){
            System.out.println("ERROR");
        }
        else{
            arr[i] = value;
        }
    }
    
    public void remove(int i){
        // FIXED THIS
        if(i >= size || i < 0){
            System.out.println("ERROR");
        }
        else{
            size--;
            for(int j = i; j <= size; j++){
                arr[j] = arr[j+1];
            }
        }
    }
    
    public boolean isEmpty(){
        // FIXED THIS
        boolean empty;
        if(size == 0){
            empty = true;
        }
        else{
            empty = false;
        }
        return empty;
    }
    
    public int getSize(){
        // FIXED THIS
        return size;
    }
    
    public void printStructure(){
        // FIXED THIS
        System.out.print("Size = " + size + ", Cap = " + capacity);
        if(size == 0){
             System.out.print(", arr = [ ]");
        }
        else{
        System.out.print(", arr = [ ");
        for(int i = 0; i < size-1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[size-1] + " ]");
        }
        System.out.println();
    }
}
