/**
 * The app demonstrates screen rotation event in Android.
 *
 * @author Rustam Galimov
 * @version 1.0
 * @since 14.11.2019
 */
package ru.job4j.a321;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ru.job4j.a321.model.Employee;
import ru.job4j.a321.model.Position;

public class MainActivity extends AppCompatActivity {

    public static final List<Position> POSITIONS = Arrays.asList(
            new Position("Director", 145),
            new Position("Manager", 256),
            new Position("Worker", 1265));

    public static final List<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Van", "Man", new Date(4578457865213L), "http://photo.png", POSITIONS.get(0)),
            new Employee("Man", "Ren", new Date(4578457865213L), "http://photo2.png", POSITIONS.get(1)),
            new Employee("Ban", "Ken", new Date(4578452365213L), "http://photo3.png", POSITIONS.get(1)),
            new Employee("San", "Ion", new Date(4578412865213L), "http://photo4.png", POSITIONS.get(2)),
            new Employee("Jan", "Lon", new Date(4578412865213L), "http://photo5.png", POSITIONS.get(2)),
            new Employee("Dan", "Kem", new Date(4578412865213L), "http://photo6.png", POSITIONS.get(2)),
            new Employee("San", "Ope", new Date(4578412865213L), "http://photo7.png", POSITIONS.get(2)));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        Fragment positionFragment = loadFrg();

        if (fm.findFragmentById(R.id.content) == null) {
            fm.beginTransaction()
                    .replace(R.id.content, positionFragment)
                    .commit();
        }
    }

    private Fragment loadFrg() {
        return new PositionFragment();
    }
}
