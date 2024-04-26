package com.dev.ojamee

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dev.ojamee.ui.main.ListEmailActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.OAuthProvider
import java.util.*


class LoginRegisterActivity : AppCompatActivity() {
    val TAG = "LoginRegisterActivity"

    val AUTHUI_REQUEST_CODE = 10001
    val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_login_register)
        handleLoginRegister()

        if (FirebaseAuth.getInstance().currentUser != null) {

            val intent = Intent(this, ListEmailActivity::class.java)

            startActivity(intent)

            this.finish()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTHUI_REQUEST_CODE) {

            if (resultCode == Activity.RESULT_OK) {

                //we have signed in user or we have a new user
                val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser

                Log.w(TAG, user?.email.toString());


                if (user?.metadata?.creationTimestamp == user?.metadata?.lastSignInTimestamp) {
                    Toast.makeText(applicationContext, "Welcome new user", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Welcome back again", Toast.LENGTH_LONG)
                        .show()
                }
                val intent = Intent(this, ListEmailActivity::class.java)
                startActivity(intent)
                this.finish()
            } else {
                //sign in failed
                val response: IdpResponse? = IdpResponse.fromResultIntent(data)

                if (response == null) {
                    Log.w(TAG, "user cancelled sign in request")

                } else {
                    Log.w(TAG, response.error)
                }
            }
        }


    }

    fun handleLoginRegister() {
        //val provider = OAuthProvider.newBuilder("yahoo.com")

        val providers: List<AuthUI.IdpConfig> = Arrays.asList(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
           // AuthUI.IdpConfig.YahooBuilder().build()
        )
        val intent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTosAndPrivacyPolicyUrls("https://example.com", "https://example.com")
            .setLogo(R.drawable.truck)
            .setAlwaysShowSignInMethodScreen(true)
            .build()



        startActivityForResult(intent, AUTHUI_REQUEST_CODE)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

}