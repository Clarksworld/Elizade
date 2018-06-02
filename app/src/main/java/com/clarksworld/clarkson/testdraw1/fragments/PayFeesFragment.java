package com.clarksworld.clarkson.testdraw1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.clarksworld.clarkson.testdraw1.R;


/**
 * Created by CLARKSWORLD on 26/04/2018.
 */

public class PayFeesFragment extends Fragment {
    TextView amount, email, cardNumber, cardExpiration,cardCvv;
    TextView save_tv;
    Switch aSwitch;
    Button paymentButton, chooseCardButton;
    FloatingActionButton floatingActionButton;

    public PayFeesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.payment_layout, container, false);
        amount = view.findViewById(R.id.amount);
        email = view.findViewById(R.id.email);
        cardNumber = view.findViewById(R.id.card_number);
        cardExpiration   = view.findViewById(R.id.card_expiring);
        cardCvv = view.findViewById(R.id.card_cvv);
        save_tv = view.findViewById(R.id.save_tv);
        aSwitch = view.findViewById(R.id.switch_btn);
        paymentButton = view.findViewById(R.id.payment_btn);
        chooseCardButton = view.findViewById(R.id.choose_card_btn);
        floatingActionButton = view.findViewById(R.id.payment_fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), " you've just hit me", Toast.LENGTH_SHORT).show();

            }
        });

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "This Feature has not yet been implemented", Toast.LENGTH_SHORT).show();
            }
        });

        chooseCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "This Feature has not yet been implemented", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
