package com.example.user.calculadora_silviopd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    RadioButton rgDecimal,rgBinario;
    EditText numero,base,potencia;
    Button aceptar,aceptar2;
    TextView imprimir,imprimir2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgBinario = (RadioButton) findViewById(R.id.btnBinario);
        rgDecimal = (RadioButton) findViewById(R.id.btnDecimal);

        numero = (EditText) findViewById(R.id.txtNumero);
        base = (EditText) findViewById(R.id.txtbase);
        potencia = (EditText) findViewById(R.id.txtpotencia);

        imprimir = (TextView) findViewById(R.id.lblNumero);
        imprimir2 = (TextView) findViewById(R.id.lblpotencia);

        aceptar = (Button) findViewById(R.id.btnAceptar);
        aceptar2 = (Button) findViewById(R.id.btnPotencia);

        imprimir.setText("");
        imprimir2.setText("");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    DecimalFormat formarFormat = new DecimalFormat("###,###");

    public void DecimalaBinario() {
        int digito, exp = 0,cont=0;
        double bi = 0;

        char punto = '.';
        String validar = numero.getText().toString();

        for (int i = 0; i < validar.length(); i++) {
            if (validar.charAt(i)==punto){
                cont++;
            }
        }

        if (!validar.isEmpty()) {
            if (cont == 0) {
                int numero1 = Integer.parseInt(numero.getText().toString());

                while (numero1 != 0) {
                    digito = numero1 % 2;
                    bi = bi + digito * Math.pow(10, exp);
                    exp++;
                    numero1 = numero1 / 2;
                }

                imprimir.setText(String.valueOf(formarFormat.format(bi)));
            } else {
                Toast.makeText(this, "Quitar punto...", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Ingrese un numero...", Toast.LENGTH_LONG).show();
        }

    }

    public void BinarioaDecimal() {
        int bi,cont=0;
        String validar = numero.getText().toString();

        char dos = '2',tres = '3',cuatro = '4',cinco = '5';
        char seis = '6', siete = '7',ocho = '8',nueve = '9',punto = '.';

        for (int i = 0; i < validar.length(); i++) {
            if (validar.charAt(i)==dos || validar.charAt(i)==tres || validar.charAt(i)==cuatro || validar.charAt(i)==cinco || validar.charAt(i)==seis || validar.charAt(i)==siete || validar.charAt(i)==ocho || validar.charAt(i)==nueve || validar.charAt(i)==punto ){
                if(validar.charAt(i)==punto){
                    Toast.makeText(this, "Quitar punto...", Toast.LENGTH_LONG).show();
                }
                cont++;}
        }

        if (!validar.isEmpty()) {
            //if (validar.length() < 9) {
                if (cont == 0) {
                    bi = Integer.parseInt(numero.getText().toString(), 2);
                    imprimir.setText(String.valueOf(formarFormat.format(bi)));
                } else {
                    Toast.makeText(this, "No es Binario...", Toast.LENGTH_LONG).show();
                }
           // } else {
             //   Toast.makeText(this, "Ingrese Digito menor a 8...", Toast.LENGTH_LONG).show();
             // }
        }else{
            Toast.makeText(this, "Ingrese un numero...", Toast.LENGTH_LONG).show();
        }
    }

    public void cambiarNumero(View view){
        if (rgDecimal.isChecked()){
            imprimir.setText("");
            DecimalaBinario();
        }

        if(rgBinario.isChecked()) {
            imprimir.setText("");
            BinarioaDecimal();
        }
    }

    public void funcionpotencia(View view){
        if (!base.getText().toString().isEmpty() && !potencia.getText().toString().isEmpty()) {
            imprimir2.setText(String.valueOf(formarFormat.format(Math.pow(Integer.parseInt(base.getText().toString()), Integer.parseInt(potencia.getText().toString())))));
        }else{
            Toast.makeText(this, "Ingrese un numero...", Toast.LENGTH_LONG).show();
        }
    }

    public void cerrarApp(View view){
        finish();
        System.exit(0);
    }

    @Override
    public void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.calculadora_silviopd/http/host/path")
        );

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction2 = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.calculadora_silviopd/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction2);
    }

    @Override
    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction2 = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.calculadora_silviopd/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction2);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.calculadora_silviopd/http/host/path")
        );

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }
}
