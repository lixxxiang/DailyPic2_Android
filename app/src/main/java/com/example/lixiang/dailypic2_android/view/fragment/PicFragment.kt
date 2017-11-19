package com.example.lixiang.dailypic2_android.view.fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import com.example.lixiang.dailypic2_android.R
import com.example.lixiang.dailypic2_android.di.components.DaggerPicComponent
import com.example.lixiang.dailypic2_android.di.modules.PicModule
import com.example.lixiang.dailypic2_android.model.entity.DailyPic
import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail
import com.example.lixiang.dailypic2_android.presenter.PicContract
import com.example.lixiang.dailypic2_android.presenter.PicPresenter
import com.example.lixiang.dailypic2_android.util.HomeListViewAdapter
import com.example.lixiang.dailypic2_android.util.NetWorkUtils
import com.example.lixiang.dailypic2_android.util.PicListViewAdapter
import com.example.lixiang.dailypic2_android.util.SwipeRefreshView
import com.example.lixiang.dailypic2_android.view.activity.PicDetailActivity
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

    override fun toPicDetailPage(picDetailContent: DailyPicDetail.DataBean?) {
        val intent = Intent(activity, PicDetailActivity::class.java)
        intent.putExtra("picDetailContent", picDetailContent)
        startActivity(intent)
    }

    var data : MutableList<DailyPic.DataBean.SjDailyPicDtoListBean> = mutableListOf()
    var adapter = PicListViewAdapter(activity, data)
    var picMaxCount = 0
    override fun loadPicData(content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean>, count: Int) {
        println("Daily Pic content" + content)
        data = content
        picMaxCount = count
        adapter = PicListViewAdapter(activity.applicationContext, content)
        listview1.adapter = adapter
    }

    override fun loadMorePicData(content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean>) {
        adapter.notifyDataSetChanged()
    }

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    var num_pic = 1
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

        listview1.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            presenter.getDailyPicDetail(data.get(position).imageId)
        }

        swipeRefreshLayout_pic.setColorSchemeColors(Color.parseColor("#6299ff"))
        swipeRefreshLayout_pic.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            presenter.loadPicData("10", "1")
            Handler().postDelayed({
                swipeRefreshLayout_pic.isRefreshing = false

            }, 1200)
        })


        // 设置下拉加载更多
        swipeRefreshLayout_pic.setOnLoadMoreListener(object : SwipeRefreshView.OnLoadMoreListener{
            override fun onLoadMore() {
                num_pic ++
                if (num_pic < picMaxCount){
                    println("num" + num_pic)
                    presenter.loadMorePicData("10", num_pic.toString())
                    swipeRefreshLayout_pic.setLoading(false)
                }
            }
        })

        if(!NetWorkUtils.isNetworkConnected(activity)){
            no_network2.visibility = View.VISIBLE
        }
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
