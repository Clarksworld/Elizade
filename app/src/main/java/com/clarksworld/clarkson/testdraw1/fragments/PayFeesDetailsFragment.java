package com.clarksworld.clarkson.testdraw1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.clarksworld.clarkson.testdraw1.R;

/**
 * Created by CLARKSWORLD on 11/05/2018.
 */

public class PayFeesDetailsFragment extends Fragment {


    EditText amount, email, cardNumber, cardExpiration,cardCvv;
    TextView save_tv;
    Switch aSwitch;
    Button paymentButton, chooseCardButton;

    public PayFeesDetailsFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_payfees, container, false);
        amount = view.findViewById(R.id.amount);
        email = view.findViewById(R.id.email);
        cardNumber = view.findViewById(R.id.card_number);
        cardExpiration   = view.findViewById(R.id.card_expiring);
        cardCvv = view.findViewById(R.id.card_cvv);
        save_tv = view.findViewById(R.id.save_tv);
        aSwitch = view.findViewById(R.id.switch_btn);
        paymentButton = view.findViewById(R.id.payment_btn);
        chooseCardButton = view.findViewById(R.id.choose_card_btn);

        return view;
    }
}
