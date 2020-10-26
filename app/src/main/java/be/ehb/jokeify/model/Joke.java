package be.ehb.jokeify.model;

import java.io.Serializable;

//Serializable nodig om data door te geven tussen schermen
public class Joke implements Serializable {

    private String setup, punchline;

    public Joke() {
    }

    public Joke(String setup, String punchline) {
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
}
