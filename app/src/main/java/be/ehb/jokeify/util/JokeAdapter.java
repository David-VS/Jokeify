package be.ehb.jokeify.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.jokeify.R;
import be.ehb.jokeify.model.Joke;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    //innner class -> wordt toch enkel binnen de adapter gebruikt
    class JokeViewHolder extends RecyclerView.ViewHolder{
        final TextView tvSetup;
        final Button btnPunchline;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSetup = itemView.findViewById(R.id.card_tv_setup);
            btnPunchline = itemView.findViewById(R.id.card_btn_details);
        }
    }

    private ArrayList<Joke> items;

    public JokeAdapter() {
        this.items = new ArrayList<>();
    }

    public void addJokes(ArrayList<Joke> newJokes){
        items = newJokes;
        //adapter zeggen dat er nieuwe data is, view opnieuw gerenderd
        notifyDataSetChanged();
    }

    //teken een eerste zichtbare rij, sla op in holder
    //holder wordt gerecycleerd voor volgende rijen die zichtbaar worden
    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //in welke context komt alles (activity)
        Context mContext = parent.getContext();
        //haal inflater uit de context
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        //build card
        View card = mLayoutInflater.inflate(R.layout.joke_card, parent, false);

        return new JokeViewHolder(card);
    }

    //vul de rij op, maak gebruik van holder om te verwijzen naar componenten in de rij
    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        Joke currentJoke = items.get(position);

        holder.tvSetup.setText(currentJoke.getSetup());
    }

    //hoeveel rijen zijn er nodig
    @Override
    public int getItemCount() {
        return items.size();
    }
}
