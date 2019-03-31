package e.adw.example1

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment_tugas_03 initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment_tugas_03 must implement the
 * [Tugas03.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Tugas03.newInstance] factory method to
 * create an instance of this fragment_tugas_03.
 *
 */
class Tugas03 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    lateinit var txt: TextView
    lateinit var layout:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val let = arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment_tugas_03

        val view = inflater.inflate(R.layout.fragment_tugas03, container, false)
        txt = view.findViewById(R.id.textView4)
        layout = view.findViewById(R.id.LayoutParent03)


        view.findViewById<Button>(R.id.merahBtn2).setOnClickListener {
            merahBtn(txt)
        }

        view.findViewById<Button>(R.id.biruBtn2).setOnClickListener {
            biruBtn(txt)
        }

        view.findViewById<Button>(R.id.hijauBtn2).setOnClickListener {
            hijauBtn(txt)
        }
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {

        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun biruBtn(v:View){
        txt.apply {
            setTextColor(Color.WHITE)
            text = context.getString(R.string.biru)
            setBackgroundColor(Color.BLUE)
        }
        layout.setBackgroundColor(Color.BLUE)
    }

    fun merahBtn(v:View){
        txt.apply {
            setTextColor(Color.WHITE)
            text = context.getString(R.string.merah)
            setBackgroundColor(Color.RED)
        }
        layout.setBackgroundColor(Color.RED)
    }
    fun hijauBtn(v:View){
        txt.apply {
            setTextColor(Color.WHITE)
            text = context.getString(R.string.hijau)
            setBackgroundColor(Color.GREEN)
        }
        layout.setBackgroundColor(Color.GREEN)
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment_tugas_03 to allow an interaction in this fragment_tugas_03 to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment_tugas_03 using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment_tugas_03 Tugas03.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tugas03().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
