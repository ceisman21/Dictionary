/*
By: Cooper Eisman
Created: 12/08/2020
Edited: 12/10/2020
Purpose: This is a list structure that implements collection and utilizes arraylists
 */

import java.util.Collection;
import java.util.Iterator;

public class CollectedList<E> implements Collection<E> {
    private int size;
    ArrayList items;

    public CollectedList() {
        size = 0;
        items = new ArrayList();
    }

    public int size() {
        return size;
    }       //Returns int that represents the length of the list

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }           //Returns true if empty

    public boolean contains(Object o) {
        try {
            if (!(items.size() == 0)) {
                for (int x = 0; x < items.size(); x++) {
                    if (items.get(x).equals(o)) {
                        return true;
                    }
                }
            }
            return false;
        } catch(Exception e){
            return false;
        }
    }  //Returns true if the list contains o

    public int getIndex(Object o) {
        return items.find(o);
    }

    public Object objAtIndex(int index) {
       return items.get(index);
    }

    public Iterator<E> iterator() {
        return null;
    }      //Not Implemented

    public Object[] toArray() {
        Object[] theArray = new Object[items.size()];
        for(int x = 0; x < items.size(); x++) {
            theArray[x] = items.get(x);
        }
        return theArray;
    }          //Creates an arr[] of all items in the list

    public <T> T[] toArray(T[] a) {
        T[] theArray = (T[]) new Object[items.size()];
        for(int x = 0; x < items.size(); x++) {
            theArray[x] = (T) items.get(x);
        }
        return theArray;
    }      //Creates a T[] of all items in list

    public boolean add(E e) {
        if(contains(e)) {
            return false;
        }
        size++;
        items.add(e);
        return true;
    }            //Adds items to the list if they don't already exist, true if array changed

    public boolean remove(Object o) {
        if(contains(o)) {
            items.remove(items.find(o));
            size--;
            return true;
        }
        return false;
    }    //Removes item from list, returns false if the item doesn't exist

    public boolean containsAll(Collection<?> c) {
        for(int x = 0; x < c.size(); x++) {
            if (!contains(c.toArray()[x])) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean isSubmit = false;
        for(int x = 0; x < c.size(); x++) {
            if(add((E) c.toArray()[x])) {
                isSubmit = true;
            }
        }
        return isSubmit;
    }

    public boolean removeAll(Collection<?> c) {
        boolean isSubmit = false;
        for(int x = 0; x < c.size(); x++) {
            if(remove((E) c.toArray()[x])) {
                isSubmit = true;
            }
        }
        return isSubmit;
    }

    public boolean retainAll(Collection<?> c) {
        boolean isSubmit = false;
        for(int x = 0; x < c.size(); x++) {
            if(!contains((E) c.toArray()[x])) {
                isSubmit = true;
                remove((E) c.toArray()[x]);
            }
        }
        return isSubmit;
    } //Do Not Use -- Developing

    public void clear() {
        while (!isEmpty()) {
            items.remove(0);
        }
        size = 0;
    }
}
