package com.example.blackjackalpha;


import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.blackjackalpha.R;


public class BetButtons extends FieldsProperties implements IButtonsAbility {
    private Context context;
    public BetButtons (Context context) {
        this.context = context;
    }

    public void setHitActnBtnVisibility() {
        if(nBet > 0)
        {
            AppCompatActivity yourActivity = (AppCompatActivity) context;
            ConstraintLayout cl = yourActivity.findViewById(R.id.cl_action_btns);
            ImageButton btn = (ImageButton) cl.getChildAt(0);
            btn.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void setVisibility(int visibility) {
        AppCompatActivity yourActivity = (AppCompatActivity) context;
        ConstraintLayout cl = yourActivity.findViewById(R.id.cl_coin_btns);
        for(int i = 0; i < cl.getChildCount(); i++)
        {
            ImageButton btn = (ImageButton) cl.getChildAt(i);
            btn.setVisibility(visibility);
        }
    }

    @Override
    public void selectAbility(int index) {
        switch (index)
        {
            case 0:
                setAbility(1);
                break;
            case 1:
                setAbility(5);
                break;
            case 2:
                setAbility(10);
                break;
            case 3:
                setAbility(25);
                break;
            case 4:
                setAbility(100);
                break;
            default:
                break;
        }
        setHitActnBtnVisibility();
    }

    @Override
    public void setAbility(int crBet) {
        nCredit -= crBet;
        nBet += crBet;
        AppCompatActivity yourActivity = (AppCompatActivity) context;
        TextView tvCredit = yourActivity.findViewById(R.id.tv_credit);
        tvCredit.setText(Integer.toString(nCredit));

        TextView tvBet = yourActivity.findViewById(R.id.tv_bet);
        tvBet.setText(Integer.toString(nBet));

        ImageView iv = yourActivity.findViewById(R.id.iv_dealer_first);
        Drawable img = yourActivity.getDrawable(R.drawable.card1);
        iv.setImageDrawable(img);
    }
}
