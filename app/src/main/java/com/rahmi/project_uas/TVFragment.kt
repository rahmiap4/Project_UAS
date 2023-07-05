package com.rahmi.project_uas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmi.project_uas.model.TV
import com.rahmi.project_uas.model.TVResponse
import com.rahmi.project_uas.service.TVApiInterface
import com.rahmi.project_uas.service.TVApiService
import kotlinx.android.synthetic.main.fragment_t_v.rv_tv_list
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TVFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TVFragment : Fragment() {
    private val tv = arrayListOf<TV>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t_v, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_tv_list.layoutManager = LinearLayoutManager(this.context)
        rv_tv_list.setHasFixedSize(true)
        getTVData { tv : List<TV> ->
            rv_tv_list.adapter = TVAdapter(tv)
        }
        showRecyclerView()
    }

    private fun getTVData(callback: (List<TV>) -> Unit){
        val apiService = TVApiService.getInstance().create(TVApiInterface::class.java)
        apiService.getTVList().enqueue(object : Callback<TVResponse> {
            override fun onFailure(call: Call<TVResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                return callback(response.body()!!.tv)
            }

        })
    }

    private fun showRecyclerView() {
        rv_tv_list.layoutManager = LinearLayoutManager(this.context)
        rv_tv_list.adapter = TVAdapter(tv)
    }

}