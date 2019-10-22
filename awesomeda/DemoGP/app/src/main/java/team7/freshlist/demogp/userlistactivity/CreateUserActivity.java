package team7.freshlist.demogp.userlistactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import team7.freshlist.demogp.R;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_user);

        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        setTitle("Create User");
    }
}
