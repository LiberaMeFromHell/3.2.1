package ru.job4j.a321.model;

import java.util.Arrays;
import java.util.List;

public class PositionStore {
    public static final List<Position> POSITIONS = Arrays.asList(
            new Position("Director", 145),
            new Position("Manager", 256),
            new Position("Worker", 1265));
}
