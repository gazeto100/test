package com.example.blackjackalpha;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.blackjackalpha.R;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Deck {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Deck() {
        Initialize();
        shuffle();
    }

    private int[] cards = {
            R.drawable.card1, R.drawable.card2, R.drawable.card3, R.drawable.card4, R.drawable.card5, R.drawable.card6, R.drawable.card7,
            R.drawable.card8, R.drawable.card9, R.drawable.card10, R.drawable.card11, R.drawable.card12, R.drawable.card13

            ,R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7,
            R.drawable.d8, R.drawable.d9, R.drawable.d10, R.drawable.d11, R.drawable.d12, R.drawable.d13

            ,R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7,
            R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.h11, R.drawable.h12, R.drawable.h13

            ,R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7,
            R.drawable.s8, R.drawable.s9, R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13
    };

    private int card_back = R.drawable.backcard;

    Map<Integer, Integer> _deck = new TreeMap<>();

    public Map<Integer, Integer> get_deck() {
        return _deck;
    }

    public int getCard_back() {
        return card_back;
    }

    private void Initialize() {
        for(int i = 0; i < 52; i++)
        {
            _deck.put(cards[i], 1);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void shuffle()
    {
        List<Integer> list = new ArrayList<>(_deck.keySet());
        Collections.shuffle(list);

        list.forEach(k->_deck.put(k,_deck.get(k)));
    }

    public void removeCard(int card)
    {
        _deck.remove(card);
    }

    public int getCard(int card)
    {
        return _deck.get((_deck.keySet().toArray())[card]);
    }


}
