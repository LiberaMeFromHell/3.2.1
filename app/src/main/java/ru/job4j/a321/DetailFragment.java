/**
 * The app demonstrates screen rotation event in Android.
 *
 * @author Rustam Galimov
 * @version 1.0
 * @since 14.11.2019
 */
package ru.job4j.a321;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.job4j.a321.model.Employee;

public class DetailFragment extends Fragment {

    private String name;
    private String sureName;

    public DetailFragment(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        Employee employee = null;

        for (Employee em: MainActivity.EMPLOYEES) {
            if (em.getName().equals(this.name) && em.getSureName().equals(this.sureName)) {
                employee = em;
                break;
            }
        }

        ((TextView)(view.findViewById(R.id.name))).setText( employee.getName());
        ((TextView)(view.findViewById(R.id.sureName))).setText(employee.getSureName());
        ((TextView)(view.findViewById(R.id.position))).setText(employee.getPosition().getName());
        ((TextView)(view.findViewById(R.id.birthDay))).setText(employee.getBirthday().toString());
        ((TextView)(view.findViewById(R.id.photo))).setText(employee.getPhotoURL());
    }
}
