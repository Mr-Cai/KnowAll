package cn.dev.knowall.fragment


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import cn.dev.knowall.R
import cn.dev.knowall.view.DeleteEdit
import java.text.DecimalFormat

class DepositFragment : Fragment() {

    private var etMoney: DeleteEdit? = null
    private var spType: Spinner? = null
    private var etYear: DeleteEdit? = null
    private var tvYear: TextView? = null
    private var etRate: DeleteEdit? = null
    private var tvAccrual: TextView? = null
    private var tvSum: TextView? = null
    private var calButton: Button? = null
    private val deposit_type = arrayOf(//下拉列表文字
            "选择存款类型", "活期", "定期", "3月定期", "6月定期", "1年定期", "2年定期", "3年定期")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_deposit, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        etMoney = view.findViewById(R.id.et_money)
        spType = view.findViewById(R.id.sp_type)
        etYear = view.findViewById(R.id.et_year)
        tvYear = view.findViewById(R.id.tv_year)
        etRate = view.findViewById(R.id.et_rate)
        tvAccrual = view.findViewById(R.id.tv_accrual)
        tvSum = view.findViewById(R.id.tv_sum)
        calButton = view.findViewById(R.id.btn_calculate)
        calButton!!.setOnClickListener {
            val text = spType!!.selectedItem.toString()
            val money = etMoney!!.text!!.toString().trim { it <= ' ' }
            val rate = etRate!!.text!!.toString().trim { it <= ' ' }
            val year = etYear!!.text!!.toString().trim { it <= ' ' }
            if (money != "" && rate != "") {
                if (text.contains("定期")) {
                    val rates = java.lang.Float.parseFloat(money) * java.lang.Float.parseFloat(rate) / 100
                    val sum = java.lang.Float.parseFloat(money) + java.lang.Float.parseFloat(money) * java.lang.Float.parseFloat(rate)
                    val format = DecimalFormat("0.00")
                    tvSum!!.setTextColor(Color.RED)
                    tvSum!!.text = format.format(sum.toDouble()) + "RMB"
                    tvAccrual!!.text = format.format(rates.toDouble()) + "RMB"
                } else if (text.contains("活期")) {
                    val rates = (java.lang.Float.parseFloat(money) * java.lang.Float.parseFloat(year)
                            * java.lang.Float.parseFloat(rate)) / 100
                    val sum = java.lang.Float.parseFloat(money) + rates
                    val format = DecimalFormat("0.00")
                    tvSum!!.setTextColor(Color.RED)
                    tvSum!!.text = format.format(sum.toDouble()) + "RMB"
                    tvAccrual!!.text = format.format(rates.toDouble()) + "RMB"
                }
            } else {
                tvSum!!.text = "RMB"
                tvYear!!.text = ""
                tvAccrual!!.text = "RMB"
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val arrayAdapter = ArrayAdapter(context,
                android.R.layout.simple_spinner_dropdown_item,
                deposit_type)
        spType!!.adapter = arrayAdapter
        spType!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val text = spType!!.selectedItem.toString()
                if (text.contains("定期") || text.contains("选择存款类型")) {
                    tvYear!!.visibility = View.GONE
                    etYear!!.visibility = View.GONE
                }
                if (position == 0) {
                    etMoney!!.setText("")
                    etRate!!.setText("")
                }
                when (text) {
                    "定期" -> etRate!!.setText(1.5.toString())
                    "3月定期" -> etRate!!.setText(1.1.toString())
                    "6月定期" -> etRate!!.setText(1.3.toString())
                    "1年定期" -> etRate!!.setText(1.5.toString())
                    "2年定期" -> etRate!!.setText(2.1.toString())
                    "3年定期" -> etRate!!.setText(2.75.toString())
                    "活期" -> {
                        etYear!!.setText(1.toString())
                        etRate!!.setText(0.35.toString())
                        tvYear!!.visibility = View.VISIBLE
                        etYear!!.visibility = View.VISIBLE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                tvYear!!.visibility = View.GONE
                etYear!!.visibility = View.GONE
                etYear!!.setText("")
                etMoney!!.setText("")
                etRate!!.setText("")
            }
        }

    }
}
