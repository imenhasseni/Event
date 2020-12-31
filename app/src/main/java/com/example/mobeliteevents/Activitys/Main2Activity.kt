package com.example.mobeliteevents.Activitys

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mobeliteevents.R
import com.example.mobeliteevents.model.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.content.Intent as Intent1


class Main2Activity : AppCompatActivity() {
     lateinit var mAuth : FirebaseAuth
     lateinit var mDatabase : DatabaseReference
    lateinit var tv_Button_continue : Button
    lateinit var mProgressBar : ProgressDialog
    lateinit var tv_phone : EditText
    lateinit var tv_etpassword : EditText
    lateinit var tv_etEmail : EditText
    lateinit var tv_username: EditText
    lateinit var tv_textlogin : TextView


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

            mAuth = FirebaseAuth.getInstance();
           // mDatabase = FirebaseDatabase.getInstance().getReference( "Users")

            tv_Button_continue = findViewById(R.id.Button_continue)
            tv_phone = findViewById(R.id.phone)
            tv_etpassword = findViewById(R.id.etpassword)
            tv_etEmail = findViewById(R.id.etEmail)
            tv_username = findViewById(R.id.username)
            tv_textlogin = findViewById(R.id.textlogin)


            tv_textlogin .setOnClickListener {
            val intent = android.content.Intent(this, LoginActivity::class.java)
            startActivity(intent )


            mProgressBar = ProgressDialog(this)
                tv_Button_continue.setOnClickListener {
                val name = tv_username.text.toString().trim()
                val email = tv_etEmail.toString().trim()
                val password = tv_etpassword.toString().trim()
                val phone =    tv_phone.toString().trim()

                if (TextUtils.isEmpty(name)){
                    tv_username.error = "Enter Frst and Last Name"
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(name)){
                    tv_etEmail.error = "Enter Email"
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(name)){
                    tv_etpassword.error = "Enter Password"
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(name)){
                    tv_phone.error = "Enter Phone"
                    return@setOnClickListener
                }
                createUser(name , email , password, phone)
            }
            }

            fun createUser(name : String , email : String , password : String , phone : String) {

                mProgressBar.setMessage("Please wait..")
                mProgressBar.show()

        val addOnCompleteListener = mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val currentUser = FirebaseAuth.getInstance().currentUser
                    val uid = currentUser!!.uid

                    val userMap = HashMap<String, String>()
                    userMap["name"] = name
                    mDatabase = FirebaseDatabase.getInstance().getReference("Users").child(uid)
                    mDatabase.setValue(userMap).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val Intent = Intent1(this, HomeActivity::class.java)
                            startActivity(Intent)
                            finish()
                            mProgressBar.dismiss()

                        }
                    }


                } else {
                        Toast.makeText(this,"Authentication failed.", Toast.LENGTH_SHORT).show()

                        mProgressBar.dismiss()

                }

    }
    }
}

    private fun createUser(name: String, email: String, password: String, phone: String) {

    }
}




