package com.example.lixiang.dailypic2_android.view.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import com.example.lixiang.dailypic2_android.R
import com.example.lixiang.dailypic2_android.di.components.DaggerVideoComponent
import com.example.lixiang.dailypic2_android.di.modules.VideoModule
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarth
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarthDetail
import com.example.lixiang.dailypic2_android.presenter.VideoContract
import com.example.lixiang.dailypic2_android.presenter.VideoPresenter
import com.example.lixiang.dailypic2_android.util.VideoListViewAdapter
import com.example.lixiang.dailypic2_android.view.activity.VideoDetailActivity
import kotlinx.android.synthetic.main.fragment_video.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [VideoFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [VideoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoFragment : Fragment(),VideoContract.View{
    override fun toVideoDetailPage(videoDetailContent: PlanetEarthDetail.DataBean?) {
        val intent = Intent(activity, VideoDetailActivity::class.java)
        intent.putExtra("VideoDetailContent", videoDetailContent)
        startActivity(intent)
    }

    var data : MutableList<PlanetEarth.DataBean.SjMobilePlanetEarthDtoListBean> = mutableListOf()
    override fun loadVideoData(videoContent: MutableList<PlanetEarth.DataBean.SjMobilePlanetEarthDtoListBean>) {
        println("Planet Earth content" + videoContent)
        data = videoContent
        val adapter = VideoListViewAdapter(activity.applicationContext, videoContent)
        listview2.adapter = adapter
    }

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    @Inject lateinit var presenter: VideoPresenter
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
        return inflater!!.inflate(R.layout.fragment_video, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        DaggerVideoComponent.builder().videoModule(VideoModule(this))
                .build()
                .inject(this)

        presenter.loadVideoData("10", "1")

        listview2.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            presenter.getPlanetEarthDetail(data.get(position).videoId)
        }
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
         * @return A new instance of fragment VideoFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): VideoFragment {
            val fragment = VideoFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
