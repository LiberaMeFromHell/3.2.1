/**
 * The app demonstrates screen rotation event in Android.
 *
 * @author Rustam Galimov
 * @version 1.0
 * @since 14.11.2019
 */
package ru.job4j.a321;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.job4j.a321.model.Position;
import ru.job4j.a321.model.PositionRecyclerViewAdapter;
import ru.job4j.a321.model.PositionStore;

public class PositionFragment extends Fragment {

    private PositionSelect positionSelect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        intiRecyclerView(view);
        return view;
    }

    private void intiRecyclerView(View view) {
        RecyclerView recycler = view.findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new PositionRecyclerViewAdapter(PositionStore.POSITIONS, positionSelect));
    }

    public interface PositionSelect{
        void positionSelected(int code);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.positionSelect = (PositionSelect)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.positionSelect = null;
    }
}
