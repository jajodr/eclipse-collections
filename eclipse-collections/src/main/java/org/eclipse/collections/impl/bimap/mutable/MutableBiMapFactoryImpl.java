/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bimap.mutable;

import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.factory.bimap.MutableBiMapFactory;

public class MutableBiMapFactoryImpl implements MutableBiMapFactory
{
    public <K, V> MutableBiMap<K, V> empty()
    {
        return HashBiMap.newMap();
    }

    public <K, V> MutableBiMap<K, V> of()
    {
        return this.empty();
    }

    public <K, V> MutableBiMap<K, V> with()
    {
        return this.empty();
    }

    public <K, V> MutableBiMap<K, V> of(K key, V value)
    {
        return this.with(key, value);
    }

    public <K, V> MutableBiMap<K, V> with(K key, V value)
    {
        return HashBiMap.newWithKeysValues(key, value);
    }

    public <K, V> MutableBiMap<K, V> of(K key1, V value1, K key2, V value2)
    {
        return this.with(key1, value1, key2, value2);
    }

    public <K, V> MutableBiMap<K, V> with(K key1, V value1, K key2, V value2)
    {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2);
    }

    public <K, V> MutableBiMap<K, V> of(K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return this.with(key1, value1, key2, value2, key3, value3);
    }

    public <K, V> MutableBiMap<K, V> with(K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    public <K, V> MutableBiMap<K, V> of(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4)
    {
        return this.with(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    public <K, V> MutableBiMap<K, V> with(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4)
    {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }
}
