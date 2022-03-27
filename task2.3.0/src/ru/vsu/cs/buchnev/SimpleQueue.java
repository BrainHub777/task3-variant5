package ru.vsu.cs.buchnev;

public interface SimpleQueue<T> {
    void add(T value);
    T remove() throws Exception;
    T element() throws Exception;
}
