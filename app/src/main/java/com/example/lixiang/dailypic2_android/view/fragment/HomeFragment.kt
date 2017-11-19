package com.example.lixiang.dailypic2_android.view.fragment

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
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.Button

import com.example.lixiang.dailypic2_android.R
import com.example.lixiang.dailypic2_android.di.components.DaggerHomeComponent
import com.example.lixiang.dailypic2_android.di.modules.HomeModule
import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarthDetail
import com.example.lixiang.dailypic2_android.model.entity.homePage
import com.example.lixiang.dailypic2_android.presenter.HomeContract
import com.example.lixiang.dailypic2_android.presenter.HomePresenter
import com.example.lixiang.dailypic2_android.util.GlideImageLoader
import com.example.lixiang.dailypic2_android.util.HomeListViewAdapter
import com.example.lixiang.dailypic2_android.util.NetWorkUtils
import com.example.lixiang.dailypic2_android.util.SwipeRefreshView
import com.example.lixiang.dailypic2_android.view.activity.IntroActivity
import com.example.lixiang.dailypic2_android.view.activity.PicDetailActivity
import com.example.lixiang.dailypic2_android.view.activity.VideoDetailActivity
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_header_view.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), HomeContract.View {


    override fun toVideoDetailPage(videoDetailContent: PlanetEarthDetail.DataBean?) {
        println("toVideoView")
        val intent = Intent(activity, VideoDetailActivity::class.java)
        intent.putExtra("VideoDetailContent", videoDetailContent)
        startActivity(intent)


    }

    override fun toPicDetailPage(picDetailContent: DailyPicDetail.DataBean?) {

        val intent = Intent(activity, PicDetailActivity::class.java)
        intent.putExtra("picDetailContent", picDetailContent)
        startActivity(intent)
    }

    var data: MutableList<homePage.DataBean.MixedContentListBean> = mutableListOf()
    var adapter = HomeListViewAdapter(activity, data)
    var maxCount = 0;
    override fun loadData(content: MutableList<homePage.DataBean.MixedContentListBean>, count: Int) {
        data = content
        maxCount = count
        println("---------->" + content.get(0).contentName)
        adapter = HomeListViewAdapter(activity.applicationContext, content)
        adapter.notifyDataSetChanged()
        listview.adapter = adapter
    }

    override fun loadMoreData(content: MutableList<homePage.DataBean.MixedContentListBean>) {
        adapter.notifyDataSetChanged()
    }

    val images = mutableListOf<String>()
    val titles = mutableListOf<String>()
    var num = 1

    @Inject lateinit var presenter: HomePresenter

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null
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
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        images.add("http://202.111.178.10:28085/upload/image/201709111935000285305.jpg")
        images.add("http://202.111.178.10:28085/upload/image/201709111935000285305.jpg")
        images.add("http://202.111.178.10:28085/upload/image/201709111935000285305.jpg")
        images.add("http://202.111.178.10:28085/upload/image/201709111935000285305.jpg")
        images.add("http://202.111.178.10:28085/upload/image/201709111935000285305.jpg")

        titles.add("1")
        titles.add("2")
        titles.add("3")
        titles.add("4")
        titles.add("5")
        val headerView = layoutInflater.inflate(R.layout.home_header_view, null)
        val banner : Banner = headerView.findViewById(R.id.banner)
        banner.setImageLoader(GlideImageLoader())
        banner.setImages(images)
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
        banner.setBannerTitles(titles)
        banner.start()

        DaggerHomeComponent.builder().homeModule(HomeModule(this))
                .build()
                .inject(this)

        listview.addHeaderView(headerView)
        listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (data.get(position - 1).type == "1")
                presenter.getDailyPicDetail(data.get(position - 1).contentId)
            else {
                presenter.getVideoPicDetail(data.get(position - 1).contentId)
            }
        }
        /**
         * test param 10,1
         */

        presenter.getHomePageData("10", "1")
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#6299ff"))
        swipeRefreshLayout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            presenter.getHomePageData("10", "1")
            Handler().postDelayed({
                swipeRefreshLayout.isRefreshing = false
            }, 1200)
        })


        // 设置下拉加载更多
        swipeRefreshLayout.setOnLoadMoreListener {
            num++
            println("num" + num)
            if (num < maxCount){
                presenter.loadMore("10", num.toString())
                swipeRefreshLayout.setLoading(false)
            }
        }
        println("////////" + NetWorkUtils.isNetworkConnected(activity))
        if(!NetWorkUtils.isNetworkConnected(activity)){
            no_network.visibility = View.VISIBLE
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
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
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        banner.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        banner.stopAutoPlay()
    }
}// Required empty public constructor
