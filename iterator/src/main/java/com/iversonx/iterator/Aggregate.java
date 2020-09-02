package com.iversonx.iterator;

import java.util.Iterator;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/6 17:03
 */
public abstract class Aggregate<T> {
    public abstract Iterator<T> createIterator();
}
