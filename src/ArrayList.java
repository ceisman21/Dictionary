import java.lang.IndexOutOfBoundsException;
/*
By: Cooper Eisman and Jim Fahey
Created: 10/01/20
Edited: 10/21/20
Purpose: The ArrayList creates an ArrayList using the Nodes Class.
 */
public class ArrayList<T>{

    private T obj;
    private Nodes firstNode;
    private Nodes lastNode;
    private int length;

    public ArrayList() {
        firstNode = new Nodes();
        lastNode = firstNode;
        length = 0;
    }

    public boolean add(T data) {
        try {
            add(length, data);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void add(int i, T data) {
        Nodes temp = new Nodes();
        temp.setObj(data);
        if(i <= 0){
            firstNode = temp;
            lastNode = temp;
            length++;
        }
        else {
            lastNode.setChild(temp);
            lastNode = temp;
            length++;
        }
    }
    public T remove(int i) { //removes a node and sets surrounding nodes as parent and child
        Nodes tempReg = firstNode;

        if(i >= length-1){
            tempReg = lastNode;
            lastNode = lastNode.getParent();
            length--;
            return (T)(tempReg.getObj());
        }
        if(i <= 0){
            tempReg = firstNode;
            firstNode = firstNode.getChild();
            length--;
            return (T)(tempReg.getObj());
        }
        else {
            for (int j = 0; j < i; j++) //access the node to be removed
            {
                tempReg = tempReg.getChild();
            }

            tempReg.getChild().setParent(tempReg.getParent());
            tempReg.getParent().setChild(tempReg.getChild());

            length--;

            return (T) (tempReg.getObj()); //return removed node
        }
    }
    public Object get(int i) {
        //Check whether i is in bounds
        if (i > length -1 || i < 0) {
            throw new ArrayIndexOutOfBoundsException("Requested index out of bounds.");
        } else {
            //Loop through using .getChild to get target node
            Nodes tempNode = firstNode;
            for (int x = 0; x < i; x++) {
                tempNode = tempNode.getChild();
            }
            return tempNode.getObj();
        }
    }
    public int find(Object o) {
        for(int x = 0;x < length; x++) {
            if(get(x).equals(o)) {
                return x;
            }
        }
        return -1;
    }

    public void set(int i, T data) {
        //Check whether i is in bounds
        if (i > length) {
            throw new ArrayIndexOutOfBoundsException("Requested index out of bounds.");
        } else {
            //Loop through using .getChild to get target node
            Nodes tempNode = firstNode;
            for (int x = 0; x < i; x++) {
                tempNode = tempNode.getChild();
            }
            tempNode.setObj(data);
        }
    }

    public int size() {
        return length;
    }
}