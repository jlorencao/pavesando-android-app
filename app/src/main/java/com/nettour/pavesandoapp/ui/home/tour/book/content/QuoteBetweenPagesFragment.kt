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
private const val ARG_QUOTE_TEXT = "quote_text"

/**
 * A simple [Fragment] subclass.
 * Use the [QuoteBetweenPagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuoteBetweenPagesFragment : Fragment() {

    private lateinit var _binding: FragmentQuoteBetweenPagesBinding



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
        val view = _binding.root
        val quoteText = arguments?.getString(ARG_QUOTE_TEXT,"")
        setQuote(quoteText.toString())

        // Inflate the layout for this fragment
        return view
    }

    fun setQuote(quoteText: String) {
        val includedLayout = _binding.quoteLayout
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