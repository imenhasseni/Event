package com.example.mobeliteevents.Activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobeliteevents.R
import com.example.mobeliteevents.model.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        Button_login.setOnClickListener {
            signinAndSignup()
        }
        mForgetpass.setOnClickListener {

           val forGetIntent = Intent(applicationContext, ForgetPassActivity::class.java)
            startActivity(forGetIntent)
        }
        btn_signup.setOnClickListener{
            val createUserIntent = Intent(applicationContext, Main2Activity::class.java)
            startActivity(createUserIntent)
        }
        logologo.alpha = 0f
        logologo.animate().setDuration(2000).alpha(1f)

    }
           fun signinAndSignup() {
                mAuth?.createUserWithEmailAndPassword(
                    Email.text.toString(),
                    password.text.toString()
                )
                    ?.addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        //creating a user account
                        moveMainPage(task.result?.user)
                    } else if(task.exception?.message.isNullOrEmpty()) {
                        //Show the error message
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                    } else {
                        //login if you have account
                        signinEmail()
                    }
                }
            }

            fun signinEmail(){
                mAuth?.signInWithEmailAndPassword(Email.text.toString(), password.text.toString())
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            //Login
                            moveMainPage(task.result?.user)
                        } else {
                            //Show the error message
                            Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()

                        }
                    }
            }

            fun moveMainPage(user: FirebaseUser?){
                if (user != null) {
                    startActivity(Intent(this, HomeActivity::class.java))
                }


            }
        }

