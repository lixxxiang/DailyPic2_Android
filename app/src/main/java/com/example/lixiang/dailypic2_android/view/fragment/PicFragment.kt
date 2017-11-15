package com.example.lixiang.dailypic2_android.view.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.lixiang.dailypic2_android.R
import com.example.lixiang.dailypic2_android.di.components.DaggerPicComponent
import com.example.lixiang.dailypic2_android.di.modules.PicModule
import com.example.lixiang.dailypic2_android.model.entity.DailyPic
import com.example.lixiang.dailypic2_android.presenter.PicContract
import com.example.lixiang.dailypic2_android.presenter.PicPresenter
import com.example.lixiang.dailypic2_android.util.HomeListViewAdapter
import com.example.lixiang.dailypic2_android.util.PicListViewAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_pic.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PicFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PicFragment : Fragment(), PicContract.View {
    var data : MutableList<DailyPic.DataBean.SjDailyPicDtoListBean> = mutableListOf()
    override fun loadPicData(content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean>) {
        println("Daily Pic content" + content)
        data = content
        val adapter = PicListViewAdapter(activity.applicationContext, content)
        listview1.adapter = adapter
    }

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null


    @Inject lateinit var presenter: PicPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_pic, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        DaggerPicComponent.builder().picModule(PicModule(this))
                .build()
                .inject(this)

        presenter.loadPicData("10", "1")
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }


    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PicFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): PicFragment {
            val fragment = PicFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
