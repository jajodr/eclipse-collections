/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.list.mutable;

import java.util.Random;

import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.test.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.test.list.UnmodifiableListTestCase;
import org.junit.Test;

public interface UnmodifiableMutableListTestCase extends UnmodifiableMutableCollectionTestCase, UnmodifiableListTestCase, MutableListTestCase
{
    @Override
    @Test(expected = UnsupportedOperationException.class)
    default void MutableList_sortThis()
    {
        this.newWith(5, 1, 4, 2, 3).sortThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    default void MutableList_shuffleThis()
    {
        this.newWith(5, 1, 4, 2, 3).shuffleThis();
        this.newWith(5, 1, 4, 2, 3).shuffleThis(new Random(8));
    }

    @Override
    @Test
    default void Iterable_remove()
    {
        UnmodifiableMutableCollectionTestCase.super.Iterable_remove();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    default void MutableList_sortThis_comparator()
    {
        this.newWith(5, 1, 4, 2, 3).sortThis(Comparators.reverseNaturalOrder());
    }
}
