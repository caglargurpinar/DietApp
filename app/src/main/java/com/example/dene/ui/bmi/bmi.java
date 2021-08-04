package com.example.dene.ui.bmi;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dene.R;

public class bmi extends Fragment {

    EditText boy;
    EditText kilo;
    Button hesapla;
    TextView sonuc;
    TextView sonuctext;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.bmi_fragment, null);

        boy = root.findViewById(R.id.etBoy);
        kilo = root.findViewById(R.id.etKilo);
        hesapla = root.findViewById(R.id.butonHesapla);
        sonuc = root.findViewById(R.id.sonuc);
        sonuctext = root.findViewById(R.id.sonuctext);

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(boy.getText().toString().equals("")) && !(kilo.getText().toString().equals(""))){
                    double boyValue = Double.parseDouble(boy.getText().toString());
                    double kiloValue = Double.parseDouble(kilo.getText().toString());
                    double result = kiloValue / (Math.pow(boyValue,2));
                    sonuc.setText(String.valueOf(result));
                    if(result<18.5){
                        sonuctext.setText("Aşırı zayıfsınız");
                        sonuctext.setTextColor(root.getResources().getColor(R.color.red));
                    }
                    else if(result<24.9){
                        sonuctext.setText("Normal kilodasınız");
                        sonuctext.setTextColor(root.getResources().getColor(R.color.green));
                    }
                    else if(result<29.9){
                        sonuctext.setText("Fazla Kilolusunuz");
                        sonuctext.setTextColor(root.getResources().getColor(R.color.yellow));
                    }
                    else{
                        sonuctext.setText("Obezite riski");
                        sonuctext.setTextColor(root.getResources().getColor(R.color.red));
                    }
                }
                else{
                    Toast.makeText(container.getContext(), "Lütfen bilgileri giriniz", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;

}}