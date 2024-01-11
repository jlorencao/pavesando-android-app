package com.nettour.pavesandoapp.ui.home.tour.map

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.FragmentMapTourBinding
import com.nettour.pavesandoapp.ui.home.tour.book.MuseumTourActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapTourFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapTourFragment : Fragment() {

    private lateinit var _binding: FragmentMapTourBinding

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapTourBinding.inflate(inflater,container,false)
        val view = _binding.root

        _binding.foundationTextView.setOnClickListener {
            //Navigate to MuseumTourActivity with BookFragment
            val intent = Intent(requireActivity(), MuseumTourActivity::class.java)
            intent.putExtra("fragment", "BookFragment" )
            startActivity(intent)
        }

        _binding.walkTextView.setOnClickListener {
            //open a webview with the link to spotfy podcast
            val intent = Intent(requireActivity(), PodcastWebViewActivity::class.java)
            startActivity(intent)
        }

        _binding.paveseHousetextView.setOnClickListener {
            //navigate to pavese house detail page
            val intent = Intent(requireActivity(), CasaPaveseActivity::class.java)
            startActivity(intent)
        }


        _binding.alertNutoTextView.setOnClickListener {
            //open a dialog with the text of alert
            showAlert()
        }

        _binding.nutoHouseTextView.setOnClickListener {
            //navigate to nuto house page detail
            val intent = Intent(requireActivity(), NutoActivity::class.java)
            startActivity(intent)
        }


        // Inflate the layout for this fragment
        return view
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Alerta di Sicurezza")
        builder.setMessage(" Per motivi di sicurezza non è possibile raggiungere a piedi la struttura della casa di Nuto.")

        builder.setPositiveButton("OK") { dialog, which ->
            // Dismiss the dialog
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MapTourFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapTourFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}