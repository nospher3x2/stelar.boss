package com.redestelar.bosses.util.storage.cache;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author oNospher
 **/
@RequiredArgsConstructor
@Getter
public abstract class NspListCache<T> {

    private final LinkedList<T> CACHE = Lists.newLinkedList();

    public void insert(T element) {
        this.CACHE.add(element);
    }

    public T fetch(Predicate<T> predicate) {
        return this.CACHE.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public List<T> fetchAll() {
        return this.CACHE;
    }
}
