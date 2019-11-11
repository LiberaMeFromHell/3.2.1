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

import ru.job4j.a321.EmployeeFragment;
import ru.job4j.a321.R;

public class PositionRecyclerViewAdapter extends RecyclerView.Adapter<PositionRecyclerViewAdapter.MyViewHolder> {

    private final List<Position> items;
    private FragmentActivity activity;

    public PositionRecyclerViewAdapter(List<Position> items, FragmentActivity activity) {
        this.items = items;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PositionRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final String item = items.get(position).getName();
        TextView textView = holder.view.findViewById(R.id.itemText);
        textView.setText(item);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrg(items.get(position).getCode());
                Log.d("clicked", "wasdadsqaw: ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private View view;

        public MyViewHolder(@NonNull final View view) {
            super(view);
            this.view = itemView;
        }
    }

    private void loadFrg(int code) throws RuntimeException {

        EmployeeFragment fragment = new EmployeeFragment(code);
        FragmentManager fm = activity.getSupportFragmentManager();
        fm.beginTransaction()
                .addToBackStack("waka?")
                .replace(R.id.content, fragment)
                .commit();
    }
}
