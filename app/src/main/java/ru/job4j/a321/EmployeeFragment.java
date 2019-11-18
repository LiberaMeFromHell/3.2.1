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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.a321.model.Employee;
import ru.job4j.a321.model.EmployeeRecyclerViewAdapter;
import ru.job4j.a321.model.EmployeeStore;

public class EmployeeFragment extends Fragment {

    private int code;

    public EmployeeFragment(int code) {
        this.code = code;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        updateUI(view);
        return view;
    }

    private void updateUI(View view) {
        List<Employee> employees = new ArrayList<>();

        for (Employee em: EmployeeStore.EMPLOYEES) {
            if (em.getPosition().getCode() == this.code) {
                employees.add(em);
            }
        }
        RecyclerView recycler = view.findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new EmployeeRecyclerViewAdapter(employees, getActivity()));
    }
}
