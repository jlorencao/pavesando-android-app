package com.nettour.pavesandoapp.ui.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.FragmentLoginBinding
import com.nettour.pavesandoapp.databinding.FragmentStartBinding
import com.nettour.pavesandoapp.ui.entry.login.LoginFragment
import com.nettour.pavesandoapp.ui.entry.registration.RegistrationFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {

    private lateinit var _binding: FragmentStartBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //initializing the binding variable with the layout
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val view = _binding.root

        //apre il fragment di login
        _binding.logInButton.setOnClickListener {
            inflateFragment(LoginFragment())

        }

        //apre il fragment di Registrazione
        _binding.signUpButton.setOnClickListener {
            inflateFragment(RegistrationFragment())
        }

        return view

    }

    private fun inflateFragment(fragment: Fragment){

        val manager = activity?.supportFragmentManager
        manager!!.beginTransaction()
            .replace(R.id.fragmentContainerView,fragment)
            .commit()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                StartFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}