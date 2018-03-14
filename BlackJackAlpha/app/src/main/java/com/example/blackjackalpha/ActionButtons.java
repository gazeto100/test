package com.example.blackjackalpha;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.blackjackalpha.BlackJackActivity;
import com.example.blackjackalpha.BetButtons;
/**
 * Created by default on 3/14/18.
 */

public class ActionButtons implements IButtonsAbility {

    private Context context;
    public ActionButtons (Context context) {
        this.context = context;
    }

    BlackJackActivity bj = new BlackJackActivity();

    private void setBetBtnsVisibility(){
        AppCompatActivity yourActivity = (AppCompatActivity) context;
        ConstraintLayout cl = yourActivity.findViewById(R.id.cl_coin_btns);
        for(int i = 0; i < cl.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl.getChildAt(i);
            btn.setVisibility(View.INVISIBLE);
        }
    }



    public void createDealBtnAbility() {
        AppCompatActivity yourActivity = (AppCompatActivity) context;
        ImageButton bt = yourActivity.findViewById(R.id.ib_hit);
        bt.setVisibility(View.INVISIBLE);
        ConstraintLayout cl = yourActivity.findViewById(R.id.cl_action_btns);
        for(int i = 1; i < cl.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl.getChildAt(i);
            btn.setVisibility(View.VISIBLE);
        }
        setBetBtnsVisibility();
    }


    @Override
    public void setAbility(int crBet) {

    }

    @Override
    public void selectAbility(int index) {
        switch (index)
        {
            case 0:{
                createDealBtnAbility();
                bj.nBet = 0;
                AppCompatActivity yourActivity = (AppCompatActivity) context;
                TextView tvBet = yourActivity.findViewById(R.id.tv_bet);
                tvBet.setText(Integer.toString(bj.nBet));
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
    public void setVisibility(int visibility) {
        AppCompatActivity yourActivity = (AppCompatActivity) context;
        ConstraintLayout cl = yourActivity.findViewById(R.id.cl_action_btns);
        for(int i = 1; i < cl.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl.getChildAt(i);
            if(bj.nBet != 0)
                btn.setVisibility(View.VISIBLE);
            else
                btn.setVisibility(View.INVISIBLE);
        }
    }
}
