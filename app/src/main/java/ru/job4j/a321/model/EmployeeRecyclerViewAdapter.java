/**
 * The app demonstrates screen rotation event in Android.
 *
 * @author Rustam Galimov
 * @version 1.0
 * @since 14.11.2019
 */
package ru.job4j.a321.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.job4j.a321.DetailFragment;
import ru.job4j.a321.R;

public class EmployeeRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeRecyclerViewAdapter.EmployeeViewHolder> {

    private final List<Employee> items;
    private FragmentActivity activity;

    public EmployeeRecyclerViewAdapter(List<Employee> items,
                                       FragmentActivity activity) {
        this.items = items;
        this.activity = activity;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, final int position) {

        TextView textView = holder.view.findViewById(R.id.itemText);
        textView.setText(items.get(position).getName() + ", " + items.get(position).getSureName());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrg(items.get(position).getName(), items.get(position).getSureName());
                Log.d("clicked", "wasdadsqaw: ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


    private void loadFrg(String name, String sureName) throws RuntimeException {

        DetailFragment fragment = new DetailFragment(name, sureName);

        FragmentManager fm = activity.getSupportFragmentManager();
        fm.beginTransaction()
                .addToBackStack("waka?")
                .replace(R.id.content, fragment)
                .commit();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private String name;

        public EmployeeViewHolder(@NonNull final View view) {
            super(view);
            this.view = itemView;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
