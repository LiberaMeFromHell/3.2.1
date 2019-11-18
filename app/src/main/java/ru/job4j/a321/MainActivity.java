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

public class MainActivity extends AppCompatActivity implements PositionFragment.PositionSelect {

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

    @Override
    public void positionSelected(int code) {

        EmployeeFragment fragment = new EmployeeFragment(code);
        FragmentManager fm = this.getSupportFragmentManager();
        fm.beginTransaction()
                .addToBackStack("waka?")
                .replace(R.id.content, fragment)
                .commit();
    }
}
