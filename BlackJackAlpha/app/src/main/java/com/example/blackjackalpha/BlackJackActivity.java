package com.example.blackjackalpha;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BlackJackActivity extends AppCompatActivity implements IBetButtons, IActionButtons {

    int nCredit = 10000;
    int nBet = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);

        CreateCoinBtnsOnClickListener();
        createActnBtnOnClickListener();

        TextView tvCredit = this.findViewById(R.id.tv_credit);
        tvCredit.setText(Integer.toString(nCredit));

        TextView tvBet = this.findViewById(R.id.tv_bet);
        tvBet.setText(Integer.toString(nBet));
    }

    @Override
    public void CreateCoinBtnsOnClickListener() {
        ConstraintLayout cl_coin_btns = this.findViewById(R.id.cl_coin_btns);
        for(int i = 0; i < cl_coin_btns.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl_coin_btns.getChildAt(i);
            final int idx = i;
            btn.setOnClickListener(view -> {
                SelectCoinBtnActivity(idx);
                setHitActnBtnVisibility();
            });
        }
    }

    @Override
    public void createActnBtnOnClickListener() {
        ConstraintLayout cl_actn_btns = this.findViewById(R.id.cl_action_btns);
        for(int i = 0; i < cl_actn_btns.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl_actn_btns.getChildAt(i);
            final int idx = i;
            btn.setOnClickListener(view -> {
                selectActionBtnActivity(idx);

            });
        }
    }

    @Override
    public void setCoinBtnActivity(int crBet) {
        nCredit -= crBet;
        nBet += crBet;
        TextView tvCredit = this.findViewById(R.id.tv_credit);
        tvCredit.setText(Integer.toString(nCredit));

        TextView tvBet = this.findViewById(R.id.tv_bet);
        tvBet.setText(Integer.toString(nBet));
    }

    @Override
    public void setActionBtnsVisibility() {
        ConstraintLayout cl = this.findViewById(R.id.cl_action_btns);
        for(int i = 1; i < cl.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl.getChildAt(i);
            if(this.nBet != 0)
                btn.setVisibility(View.VISIBLE);
            else
                btn.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void setHitActnBtnVisibility() {
        if(nBet > 0)
        {
            ConstraintLayout cl = this.findViewById(R.id.cl_action_btns);
            ImageButton btn = (ImageButton) cl.getChildAt(0);
            btn.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void selectActionBtnActivity(int index) {
        switch (index)
        {
            case 0:{
                createDealBtnActivity();
                this.nBet = 0;
                TextView tvBet = this.findViewById(R.id.tv_bet);
                tvBet.setText(Integer.toString(nBet));
            }
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                break;
        }
    }


    @Override
    public void SelectCoinBtnActivity(int index) {
        switch (index)
        {
            case 0:
                setCoinBtnActivity(1);
                break;
            case 1:
                setCoinBtnActivity(5);
                break;
            case 2:
                setCoinBtnActivity(10);
                break;
            case 3:
                setCoinBtnActivity(25);
                break;
            case 4:
                setCoinBtnActivity(100);
                break;
            default:
                break;
        }
    }

    @Override
    public void createDealBtnActivity() {
        ImageButton bt = this.findViewById(R.id.ib_hit);
        bt.setVisibility(View.INVISIBLE);
        ConstraintLayout cl = this.findViewById(R.id.cl_action_btns);
        for(int i = 1; i < cl.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl.getChildAt(i);
                btn.setVisibility(View.VISIBLE);
        }
    }
}
