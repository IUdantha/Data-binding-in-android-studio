package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var formData: FormData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        formData = FormData("", "", "", "", "")


//       instead of use -> val edtName = findViewById<EditText>(R.id.edtName),  we can use following
        val edtName: EditText = binding.edtName

        val edtEmail: EditText = binding.edtEmail
        val edtPhone: EditText = binding.edtPhone
        val edtPassword: EditText = binding.edtPassword
        val edtRePassword: EditText = binding.edtRePassword
        val btnSubmit: Button = binding.btnSubmit
        val btnCancel: Button = binding.btnCancel




        btnSubmit.setOnClickListener {
            formData.name = edtName.text.toString()
            formData.email = edtEmail.text.toString()
            formData.phone = edtPhone.text.toString()
            formData.password = edtPassword.text.toString()
            formData.rePassword = edtRePassword.text.toString()

            showAlertBox(
                this,
                formData
            )
        }

        btnCancel.setOnClickListener {
            edtName.setText("")
            edtEmail.setText("")
            edtPhone.setText("")
            edtPassword.setText("")
            edtRePassword.setText("")
        }
    }


}


fun showAlertBox(
    context: Context,
//    name: String,
//    email: String,
//    phone: String,
//    password: String,
//    rePassword: String
    formData: FormData
) {
    val builder = AlertDialog.Builder(context)
    val message =
//        "Email: $email\n" + "Phone: $phone\n" + "Passwords: ${if (password == rePassword) "Matching" else "No Matching"}."
        "Email : ${formData.email}\n" + "Phone number : ${formData.phone}\n" + "Password : ${if (formData.password == formData.rePassword) "Matching" else "No matching"}."

    builder.setTitle("Welcome ${formData.name}")
    builder.setMessage(message)
    builder.setPositiveButton("Ok") { _, _ ->
        Toast.makeText(context, "Submitted", Toast.LENGTH_LONG).show()
    }


    builder.setNegativeButton("Cancel") { _, _ ->
    }

    val dialog = builder.create()
    dialog.show()
}


