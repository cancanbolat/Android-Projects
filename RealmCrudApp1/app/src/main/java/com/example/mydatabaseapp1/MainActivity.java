package com.example.mydatabaseapp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    ListView listView;
    EditText username, name, password;
    RadioGroup malefemale;
    Button signupBtn, updateBtn;
    Integer Uposition = 0;
    String malefemaleText, usernameText, nameText, passwordText;
    RealmResults<personInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        realmAdd();
        showXML();
        addTable();
        showDatas();
        positionRead();
    
    }

    public void realmAdd() {
        realm = Realm.getDefaultInstance();
    }

    public void showXML() {
        listView = findViewById(R.id.listView);
        username = findViewById(R.id.editUsername);
        name = findViewById(R.id.editName);
        password = findViewById(R.id.editPassword);
        malefemale = findViewById(R.id.radioMF);
        signupBtn = findViewById(R.id.signupButton);
        updateBtn = findViewById(R.id.updateButton);
    }

    public void addTable() {

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutInfos();

                write(malefemaleText, nameText, usernameText, passwordText);

                username.setText("");
                name.setText("");
                password.setText("");

            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatabaseList();
                final personInfo person = list.get(Uposition);

                layoutInfos();

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        person.setUsername(usernameText);
                        person.setName(nameText);
                        person.setPassword(passwordText);
                        person.setMalefemale(malefemaleText);
                    }
                });
                showDatas();
            }
        });

    }

    public void write(final String malefemale, final String name, final String username, final String password) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                personInfo PersonInfo = realm.createObject(personInfo.class);
                PersonInfo.setName(name);
                PersonInfo.setUsername(username);
                PersonInfo.setPassword(password);
                PersonInfo.setMalefemale(malefemale);

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                showDatas();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showDatas() {
        getDatabaseList();

        if (list.size() > 0) {
            adapter adapter = new adapter(list, getApplicationContext());
            listView.setAdapter(adapter);
        }

    }

    public void positionRead() {

        getDatabaseList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openAlert(position);

                username.setText(list.get(position).getUsername());
                name.setText(list.get(position).getName());
                password.setText(list.get(position).getPassword());

                if (list.get(position).getMalefemale().equals("Male")) { //rb
                    ((RadioButton) malefemale.getChildAt(0)).setChecked(true);
                } else {
                    ((RadioButton) malefemale.getChildAt(1)).setChecked(true);
                }
                Uposition = position;
            }
        });
    }

    public void delete(final int position) {
        getDatabaseList();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                personInfo person = list.get(position);
                person.deleteFromRealm();
                showDatas();
            }
        });
    }

    public void openAlert(final int position) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alertlayout, null);

        Button yesBtn = view.findViewById(R.id.yesButton);
        Button noBtn = view.findViewById(R.id.noButton);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setView(view);
        alert.setCancelable(false);

        final AlertDialog dialog = alert.create();

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(position);
                dialog.cancel();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();

    }

    public void layoutInfos() {

        Integer radioID = malefemale.getCheckedRadioButtonId();//rb
        RadioButton radioButton = findViewById(radioID);//rb
        malefemaleText = radioButton.getText().toString();//rb

        usernameText = username.getText().toString();
        nameText = name.getText().toString();
        passwordText = password.getText().toString();

    }

    public void getDatabaseList(){
        list = realm.where(personInfo.class).findAll();
    }

}
