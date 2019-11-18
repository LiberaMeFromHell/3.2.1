package ru.job4j.a321.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static ru.job4j.a321.model.PositionStore.POSITIONS;

public class EmployeeStore {
    public static final List<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Van", "Man", new Date(4578457865213L), "http://photo.png", POSITIONS.get(0)),
            new Employee("Man", "Ren", new Date(4578457865213L), "http://photo2.png", POSITIONS.get(1)),
            new Employee("Ban", "Ken", new Date(4578452365213L), "http://photo3.png", POSITIONS.get(1)),
            new Employee("San", "Ion", new Date(4578412865213L), "http://photo4.png", POSITIONS.get(2)),
            new Employee("Jan", "Lon", new Date(4578412865213L), "http://photo5.png", POSITIONS.get(2)),
            new Employee("Dan", "Kem", new Date(4578412865213L), "http://photo6.png", POSITIONS.get(2)),
            new Employee("San", "Ope", new Date(4578412865213L), "http://photo7.png", POSITIONS.get(2)));
}
