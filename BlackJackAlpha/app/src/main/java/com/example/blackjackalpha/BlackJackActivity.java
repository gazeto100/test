package com.example.blackjackalpha;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class BlackJackActivity extends AppCompatActivity {

    public BlackJackActivity () {}
    int nCredit = 10000;
    int nBet = 0;

    BetButtons bet_btns;
    ActionButtons act_btns;

    MainButtonAbility main_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);

        bet_btns = new BetButtons(this);
        bet_btns.setVisibility(View.VISIBLE);

        act_btns = new ActionButtons(this);

//        main_btn = new MainButtonAbility(this);

        CreateCoinBtnsOnClickListener();
        createActnBtnOnClickListener();

        TextView tvCredit = this.findViewById(R.id.tv_credit);
        tvCredit.setText(Integer.toString(nCredit));

        TextView tvBet = this.findViewById(R.id.tv_bet);
        tvBet.setText(Integer.toString(nBet));
    }

    public void CreateCoinBtnsOnClickListener() {
        ConstraintLayout cl_coin_btns = this.findViewById(R.id.cl_coin_btns);
        for(int i = 0; i < cl_coin_btns.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl_coin_btns.getChildAt(i);
            final int idx = i;
            btn.setOnClickListener(view -> {
                bet_btns.selectAbility(idx);
//                main_btn.selectBetAbility(idx);


            });
        }
    }

    public void createActnBtnOnClickListener() {
        ConstraintLayout cl_actn_btns = this.findViewById(R.id.cl_action_btns);
        for(int i = 0; i < cl_actn_btns.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl_actn_btns.getChildAt(i);
            final int idx = i;
            btn.setOnClickListener(view -> {
                act_btns.selectAbility(idx);
            });
        }
    }


}
