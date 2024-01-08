package com.nettour.pavesandoapp.ui.home.tour.book.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.FragmentQuoteBetweenPagesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuoteBetweenPagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuoteBetweenPagesFragment : Fragment() {

    private var _binding: FragmentQuoteBetweenPagesBinding? = null
    private val binding get() = _binding!!


    // TODO: Rename and change types of parameters
    private var ARG_QUOTE_TEXT: String = "quote text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuoteBetweenPagesBinding.inflate(inflater,container,false)
        val view = binding.root
        val quoteText = arguments?.getString(ARG_QUOTE_TEXT,"")
        setQuote(quoteText.toString())

        // Inflate the layout for this fragment
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun setQuote(quoteText: String) {
        val includedLayout = binding.quoteLayout
        val quoteView = includedLayout.quoteTextView
            quoteView.text = quoteText
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuoteBetweenPagesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(quoteText: String) =
            QuoteBetweenPagesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_QUOTE_TEXT, quoteText)
                }
            }
    }
}