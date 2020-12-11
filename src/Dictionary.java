/*
By: Cooper Eisman
Created: 12/08/2020
Edited: 12/10/2020
Purpose: Uses two Collected Lists to create a Key-Cal dictionary
 */

import java.util.*;

public class Dictionary<E,T> {
    private CollectedList<E> keys;
    private CollectedList<T> values;
    private int size;

    public Dictionary() {
        keys = new CollectedList<E>();
        values = new CollectedList<T>();
    }

    //add an key-value pair to the dictionary
    void put(E key, T value) {
        keys.add(key);
        values.add(value);
        size++;
    }

    //get the value associated with a given key
    T get(E key) {
        return (T) values.objAtIndex(keys.getIndex(key));
    }

    //remove a key-value pair and return its value
    T remove(E key) {
        T temp = (T) values.objAtIndex(keys.getIndex(key));
        values.remove((T) values.objAtIndex(keys.getIndex(key)));
        keys.remove(key);
        size--;
        return temp;
    }

    //returns true if the given key has an associated value
    boolean contains(E key) {
        return keys.contains(key);
    }

    //returns true if the dictionary is empty
    boolean isEmpty() {
        return size == 0;
    }

    //returns the number of key-value pairs in the dictionary
    int size() {
        return size;
    }

    //returns a Collection¹ of keys
    Collection<E> keys() {
        return keys;
    }

    //returns a Collection of values
    Collection<T>  values() {
        return values;
    }

}
