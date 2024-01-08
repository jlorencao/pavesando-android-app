package com.nettour.pavesandoapp.ui.home.tour.book.content

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chibde.visualizer.LineBarVisualizer
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.FragmentChapterTwoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChapterTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChapterTwoFragment : Fragment() {

    private lateinit var _binding: FragmentChapterTwoBinding
    private var mediaPlayer: MediaPlayer? = null
    lateinit var lineBarVisualizer : LineBarVisualizer

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
        _binding = FragmentChapterTwoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val view = _binding.root

        setContent()
        val includeBinding = _binding.contentLayout
        lineBarVisualizer = _binding.contentLayout.audioVisualizer
        lineBarVisualizer.setDensity(70F)
        lineBarVisualizer.setColor(R.color.black)

        includeBinding.controlAudioButton.setOnClickListener {
            Log.d("AUDIO_BUTTON", "clicked")
            if (mediaPlayer?.isPlaying == true){
                _binding.contentLayout.controlAudioButton.setImageResource(R.drawable.baseline_play_arrow_24)
                pauseAudio()
                lineBarVisualizer.visibility = View.GONE
            } else {
                includeBinding.controlAudioButton.setImageResource(R.drawable.baseline_pause_24)
                lineBarVisualizer.visibility = View.VISIBLE
                //play audio
                playAudio(R.raw.audio_chapter_two)
                lineBarVisualizer.setPlayer(mediaPlayer!!.audioSessionId)
                Log.d("AUDIO_BUTTON", "play")
            }

            Log.d("AUDIO_BUTTON", "pause")

        }


        // Inflate the layout for this fragment
        return view
    }

    override fun onStop() {
        super.onStop()
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
    fun setContent(){
        //setting the texts
        _binding.contentLayout.chapterLabelTextView.text = getString(R.string.chapter_two_label)
        _binding.contentLayout.chapterTitleTextView.text = getString(R.string.chapter_two_title)
        _binding.contentLayout.firstParagraphTextView.text = getString(R.string.chapter_two_first_paragraph)
        _binding.contentLayout.firstParagraphBelowImageTextView.text = getString(R.string.chapter_two_first_paragraph_below_image)
        _binding.contentLayout.secondParagraphTextView.text = getString(R.string.chapter_two_second_paragraph)
        _binding.contentLayout.thirdParagraphTextView.text = getString(R.string.chapter_two_third_paragraph)
        _binding.contentLayout.callToActionTextView.text = getString(R.string.chapter_two_call_to_action)

        //setting Images


        //setting video

    }

    private fun playAudio(audioFile: Int){
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, audioFile)
            mediaPlayer!!.isLooping = true
            mediaPlayer!!.start()
        } else mediaPlayer!!.start()
    }

    private fun pauseAudio(){
        mediaPlayer?.pause()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChapterTwoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChapterTwoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}