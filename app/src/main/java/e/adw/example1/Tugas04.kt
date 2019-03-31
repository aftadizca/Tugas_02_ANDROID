package e.adw.example1

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Tugas04.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Tugas04.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Tugas04 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    lateinit var enCb:CheckBox
    lateinit var idCb:CheckBox
    lateinit var nhCb:CheckBox
    lateinit var geCb:CheckBox
    lateinit var selAll:Button
    lateinit var desAll:Button

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tugas04, container, false)

        enCb = view.findViewById(R.id.en_cb)
        idCb = view.findViewById(R.id.id_cb)
        nhCb = view.findViewById(R.id.nh_cb)
        geCb = view.findViewById(R.id.ge_cb)
        selAll = view.findViewById(R.id.selAll)
        desAll = view.findViewById(R.id.desAll)

        val cbContainer = view.findViewById<LinearLayout>(R.id.cb_container)

        enCb.setOnCheckedChangeListener { p0, p1 -> enCb.changeText(p1) }
        idCb.setOnCheckedChangeListener { p0, p1 -> idCb.changeText(p1) }
        geCb.setOnCheckedChangeListener { p0, p1 -> geCb.changeText(p1) }
        nhCb.setOnCheckedChangeListener { p0, p1 -> nhCb.changeText(p1) }

        selAll.setOnClickListener {
            for (i in 0 until cbContainer.childCount){
                (cbContainer.getChildAt(i) as CheckBox).isChecked = true
            }
        }

        desAll.setOnClickListener {
            for (i in 0 until cbContainer.childCount){
                (cbContainer.getChildAt(i) as CheckBox).isChecked = false
            }
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


    private fun CheckBox.changeText(check:Boolean){
        val text = this.text.toString()
        if(check){
            this.text = text.replace(" tidak","",true)
        }else{
            this.text = text.substring(0,text.length - 9) + " Tidak Terpilih"
        }
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
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
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tugas04.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tugas04().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
