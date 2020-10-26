package be.ehb.jokeify.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class JokeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Joke>> jokes;

    public JokeViewModel() {
    }

    //in het echt komt dit uit een database of webservice, eerder inladen
    public MutableLiveData<ArrayList<Joke>> getJokes() {
        if(jokes == null){
             jokes = new MutableLiveData<>();

             ArrayList<Joke> tempJokes = new ArrayList<>();
             tempJokes.add(new Joke("Het is blauw en weegt niet veel", "lichtblauw"));
             tempJokes.add(new Joke("Het is groen en glijd van een berg", "slawine"));
             tempJokes.add(new Joke("Het is wit en het ontploft", "Boemkool"));

             jokes.setValue(tempJokes);
        }
        return jokes;
    }
}
