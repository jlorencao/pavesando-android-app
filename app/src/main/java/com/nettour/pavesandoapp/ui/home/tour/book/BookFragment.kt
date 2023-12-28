package com.nettour.pavesandoapp.ui.home.tour.book

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.FragmentBookBinding
import com.nettour.pavesandoapp.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookFragment : Fragment() {

    private lateinit var _binding: FragmentBookBinding
    private lateinit var leftViewPager: ViewPager
    lateinit var leftPageAdapter: BookPageAdapter
    private lateinit var rightViewPager: ViewPager
    lateinit var rightPageAdapter: BookPageAdapter

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
        //initializing the binding variable with the layout

        _binding = FragmentBookBinding.inflate(inflater, container, false)
        val view = _binding.root

        val numPages: Int = 6

        //initializing ViewPager and PageAdapter
        leftViewPager = _binding.leftPageViewPager
        leftPageAdapter = BookPageAdapter(numPages)
        leftViewPager.adapter = leftPageAdapter
        leftViewPager.setPageTransformer(true,DoublePageTransform(numPages))
        leftViewPager.currentItem = 0


        rightViewPager = _binding.rightPageViewPager
        rightPageAdapter = BookPageAdapter(numPages)
        rightViewPager.adapter = rightPageAdapter
        rightViewPager.setPageTransformer(true,DoublePageTransform(numPages))
        leftViewPager.currentItem = 1


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}