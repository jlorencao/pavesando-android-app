package com.nettour.pavesandoapp.ui.entry.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nettour.pavesandoapp.databinding.FragmentRegistrationBinding
import com.nettour.pavesandoapp.ui.home.HomeActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {

    //declaring Firebase Auth and binding variables
    private lateinit var auth: FirebaseAuth
    private lateinit var _binding: FragmentRegistrationBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //initializing Firebase auth
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //initializing the binding variable with the layout
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = _binding.root

        //logic to the login button
        _binding.signUpButton.setOnClickListener {

            //getting the information from the edit texts
            val email = _binding.emailEditText.text.trim().toString()
            val password = _binding.passwordEditText.text.trim().toString()
            val checkPassword = _binding.checkPasswordEditText.text.trim().toString()


            //dobbiamo controlare se la password ha una lunghezza di al meno 6 numeri/lettere e se è uguale alla conferma password
            if(password.length >= 6 && password == checkPassword) {

                //chiamando la funzione signUpWithEmailAndPassword con i parametri email e password
                signUpWithEmailAndPassword(email, password)

            }


        }

        return view
    }



    private fun signUpWithEmailAndPassword(email: String, password: String){

        //disabilita il bottone di login per l'utente non premere piu di una volta
        _binding.signUpButton.isEnabled = false

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->

                //abilita il bottone di login
                _binding.signUpButton.isEnabled = true

                if (task.isSuccessful) {
                    //Registrazione è andata a buon fine
                    val user = auth.currentUser

                    Log.d("FIREBASE_AUTH", "Registrazione OK")

                    //navigazione alla home activity
                    val intent = Intent(requireActivity(), HomeActivity::class.java)
                    startActivity(intent)

                } else {

                    //Registration Failed
                    Log.e("FIREBASE_AUTH", "Registration Failed")
                }
            }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}