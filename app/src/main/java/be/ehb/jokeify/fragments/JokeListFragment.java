package be.ehb.jokeify.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import be.ehb.jokeify.R;
import be.ehb.jokeify.model.Joke;
import be.ehb.jokeify.model.JokeViewModel;
import be.ehb.jokeify.util.JokeAdapter;


public class JokeListFragment extends Fragment {

    JokeAdapter jokeAdapter;

    public JokeListFragment() {
        // Required empty public constructor
    }

    public static JokeListFragment newInstance() {
        return new JokeListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_list, container, false);

        //verwijzen naar UI
        final RecyclerView rvJokes = rootView.findViewById(R.id.rv_jokes);
        jokeAdapter = new JokeAdapter();
        rvJokes.setAdapter(jokeAdapter);

        //opvragen data -> ViewModel
        JokeViewModel model = new ViewModelProvider(this).get(JokeViewModel.class);
        model.getJokes().observeForever(new Observer<ArrayList<Joke>>() {
            @Override
            public void onChanged(ArrayList<Joke> jokes) {
                jokeAdapter.addJokes(jokes);
            }
        });

        //welke layout gebruiken
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rvJokes.setLayoutManager(manager);

        return rootView;
    }
}