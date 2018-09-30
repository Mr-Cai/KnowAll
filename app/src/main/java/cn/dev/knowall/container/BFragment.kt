package cn.dev.knowall.container

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import cn.dev.knowall.R
import cn.dev.knowall.controller.CardAdapter
import cn.dev.knowall.utils.Item
import kotlinx.android.synthetic.main.fragment_trip.*
import java.util.*

class BFragment : Fragment() {
    private var itemList = ArrayList<Item>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_trip, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = CardAdapter(itemList)
        trip_recyclerView.layoutManager = GridLayoutManager(context, 1)
        itemList.add(Item(R.drawable.weather, "天气"))
        itemList.add(Item(R.drawable.train, "列车"))
        itemList.add(Item(R.drawable.flight, "航班"))
        trip_recyclerView.adapter = adapter
    }
}
