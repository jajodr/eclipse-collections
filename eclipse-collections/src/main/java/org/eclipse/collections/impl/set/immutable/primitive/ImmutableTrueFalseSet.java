/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.immutable.primitive;

import java.io.IOException;
import java.io.Serializable;
import java.util.NoSuchElementException;

import net.jcip.annotations.Immutable;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectBooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.BooleanSet;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.lazy.primitive.LazyBooleanIterableAdapter;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;

@Immutable
final class ImmutableTrueFalseSet implements ImmutableBooleanSet, Serializable
{
    static final ImmutableBooleanSet INSTANCE = new ImmutableTrueFalseSet();

    private ImmutableTrueFalseSet()
    {
        // Singleton
    }

    public ImmutableBooleanSet newWith(boolean element)
    {
        return ImmutableTrueFalseSet.INSTANCE;
    }

    public ImmutableBooleanSet newWithout(boolean element)
    {
        return element ? ImmutableFalseSet.INSTANCE : ImmutableTrueSet.INSTANCE;
    }

    public ImmutableBooleanSet newWithAll(BooleanIterable elements)
    {
        ImmutableBooleanSet result = this;
        BooleanIterator booleanIterator = elements.booleanIterator();
        while (booleanIterator.hasNext())
        {
            result = result.newWith(booleanIterator.next());
        }
        return result;
    }

    public ImmutableBooleanSet newWithoutAll(BooleanIterable elements)
    {
        ImmutableBooleanSet result = this;
        BooleanIterator booleanIterator = elements.booleanIterator();
        while (booleanIterator.hasNext())
        {
            result = result.newWithout(booleanIterator.next());
        }
        return result;
    }

    public BooleanIterator booleanIterator()
    {
        return new FalseTrueIterator();
    }

    public void forEach(BooleanProcedure procedure)
    {
        this.each(procedure);
    }

    /**
     * @since 7.0.
     */
    public void each(BooleanProcedure procedure)
    {
        procedure.value(false);
        procedure.value(true);
    }

    public <T> T injectInto(T injectedValue, ObjectBooleanToObjectFunction<? super T, ? extends T> function)
    {
        return function.valueOf(function.valueOf(injectedValue, false), true);
    }

    public int count(BooleanPredicate predicate)
    {
        int count = 0;
        if (predicate.accept(false))
        {
            count++;
        }
        if (predicate.accept(true))
        {
            count++;
        }
        return count;
    }

    public boolean anySatisfy(BooleanPredicate predicate)
    {
        return predicate.accept(false) || predicate.accept(true);
    }

    public boolean allSatisfy(BooleanPredicate predicate)
    {
        return predicate.accept(false) && predicate.accept(true);
    }

    public boolean noneSatisfy(BooleanPredicate predicate)
    {
        return !predicate.accept(false) && !predicate.accept(true);
    }

    public ImmutableBooleanSet select(BooleanPredicate predicate)
    {
        if (predicate.accept(true))
        {
            return predicate.accept(false) ? this : ImmutableTrueSet.INSTANCE;
        }
        return predicate.accept(false) ? ImmutableFalseSet.INSTANCE : ImmutableBooleanEmptySet.INSTANCE;
    }

    public ImmutableBooleanSet reject(BooleanPredicate predicate)
    {
        if (predicate.accept(true))
        {
            return predicate.accept(false) ? ImmutableBooleanEmptySet.INSTANCE : ImmutableFalseSet.INSTANCE;
        }
        return predicate.accept(false) ? ImmutableTrueSet.INSTANCE : this;
    }

    public boolean detectIfNone(BooleanPredicate predicate, boolean ifNone)
    {
        if (predicate.accept(false))
        {
            return false;
        }
        if (predicate.accept(true))
        {
            return true;
        }
        return ifNone;
    }

    public <V> ImmutableSet<V> collect(BooleanToObjectFunction<? extends V> function)
    {
        return Sets.immutable.with(function.valueOf(false), function.valueOf(true));
    }

    public boolean[] toArray()
    {
        return new boolean[]{false, true};
    }

    public boolean contains(boolean value)
    {
        return true;
    }

    public boolean containsAll(boolean... source)
    {
        return true;
    }

    public boolean containsAll(BooleanIterable source)
    {
        return true;
    }

    public BooleanSet freeze()
    {
        return this;
    }

    public ImmutableBooleanSet toImmutable()
    {
        return this;
    }

    public int size()
    {
        return 2;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public boolean notEmpty()
    {
        return true;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof BooleanSet))
        {
            return false;
        }

        BooleanSet other = (BooleanSet) obj;
        return other.contains(false) && other.contains(true);
    }

    @Override
    public int hashCode()
    {
        return 2468;
    }

    @Override
    public String toString()
    {
        return "[false, true]";
    }

    public String makeString()
    {
        return "false, true";
    }

    public String makeString(String separator)
    {
        return "false" + separator + "true";
    }

    public String makeString(String start, String separator, String end)
    {
        return start + "false" + separator + "true" + end;
    }

    public void appendString(Appendable appendable)
    {
        try
        {
            appendable.append("false, true");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void appendString(Appendable appendable, String separator)
    {
        try
        {
            appendable.append("false");
            appendable.append(separator);
            appendable.append("true");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        try
        {
            appendable.append(start);
            appendable.append("false");
            appendable.append(separator);
            appendable.append("true");
            appendable.append(end);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public MutableBooleanList toList()
    {
        return BooleanArrayList.newList(this);
    }

    public MutableBooleanSet toSet()
    {
        return BooleanHashSet.newSet(this);
    }

    public MutableBooleanBag toBag()
    {
        return BooleanHashBag.newBag(this);
    }

    public LazyBooleanIterable asLazy()
    {
        return new LazyBooleanIterableAdapter(this);
    }

    private static final class FalseTrueIterator implements BooleanIterator
    {
        private int currentIndex;

        public boolean next()
        {
            switch (this.currentIndex)
            {
                case 0:
                    this.currentIndex++;
                    return false;
                case 1:
                    this.currentIndex++;
                    return true;
                default:
                    throw new NoSuchElementException();
            }
        }

        public boolean hasNext()
        {
            return this.currentIndex < 2;
        }
    }

    private Object writeReplace()
    {
        return new ImmutableBooleanSetSerializationProxy(this);
    }
}
