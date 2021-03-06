package demo.android.com.myapplication

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.*

class MainActivity2 : AppCompatActivity(),ChartValueAdapter2.AdapterCallback2 {

    private lateinit var chart: LineChart

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        chart = findViewById<LineChart>(R.id.chart1)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        defineChart()
        showData(randomData())
        setRecyclerViewData()
    }


    private fun setRecyclerViewData() {
        val model = Model()
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))

        var chartsAdapter = ChartValueAdapter2(model, this)

        recyclerView.adapter = chartsAdapter
    }

    fun showData( doubleArrayList :ArrayList<Double>) {
        val dataSets = ArrayList<ILineDataSet>()

        val values1 = ArrayList<Entry>()

        val size = doubleArrayList.size

        for (c in 0 until size) {
            values1.add(Entry(c.toFloat(), doubleArrayList[c].toFloat()))
        }

        val d1 = LineDataSet(values1, "DataSet " + 1)
        d1.lineWidth = 3.5f
        d1.setDrawCircles(false)
        d1.color = ContextCompat.getColor(this, R.color.dodger_blue)
        dataSets.add(d1)
        d1.setDrawValues(false)
        d1.setDrawHorizontalHighlightIndicator(false); d1.setDrawVerticalHighlightIndicator(false);
        d1.setHighlightEnabled(false);

        val data = LineData(dataSets)

        chart.data = data
        chart.invalidate()
        chart.animateX(1000)
    }


    private fun defineChart() {
        chart.setDrawGridBackground(false)
        chart.getDescription().setEnabled(false)
        chart.setTouchEnabled(true)
        chart.setDragEnabled(true)
        chart.setHighlightPerTapEnabled(true)
        chart.setHighlightPerDragEnabled(true)
        chart.getLegend().setEnabled(false)
        chart.setDrawBorders(false)
        val xAxis = chart.getXAxis()
        xAxis.removeAllLimitLines()
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        chart.getAxisRight().setEnabled(false)
        chart.animateX(1000)
    }

    override fun onMethodCallback(model: SelectorModel) {

        val value = model.getValue()
        if (value.equals("10MIN")) {
            showData(randomData())
        } else if (value.equals("1H")) {
            showData(randomData2())
        } else if (value.equals("10H")) {
            showData(randomData3())
        } else if (value.equals("1M")) {
            showData(randomData4())
        } else if (value.equals("3M")) {
            showData(randomData5())
        } else if (value.equals("1Y")) {
            showData(randomData6())
        }
    }

    fun  Model() : ArrayList<SelectorModel>{
        val list = ArrayList<SelectorModel>()
        val selectorModel =  SelectorModel()
        selectorModel.setValue("10MIN")
        selectorModel.setSelected(true)
        list.add(selectorModel)

        val selectorModel1 =  SelectorModel()
        selectorModel1.setValue("1H")
        selectorModel1.setSelected(false)
        list.add(selectorModel1)

        val selectorModel2 =  SelectorModel()
        selectorModel2.setValue("10H")
        selectorModel2.setSelected(false)
        list.add(selectorModel2)

        val selectorModel3 =  SelectorModel()
        selectorModel3.setValue("1M")
        selectorModel3.setSelected(false)
        list.add(selectorModel3)

        val selectorModel4 =  SelectorModel()
        selectorModel4.setValue("3M")
        selectorModel4.setSelected(false)
        list.add(selectorModel4)

        val selectorModel5 =  SelectorModel()
        selectorModel5.setValue("1Y")
        selectorModel5.setSelected(false)
        list.add(selectorModel5)

        return list
    }

    fun randomData(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(0.0)
        random.add(20.0)
        random.add(33.0)
        random.add(17.0)
        random.add(20.0)
        random.add(34.0)
        random.add(40.0)
        random.add(43.0)
        random.add(45.0)
        random.add(55.0)
        random.add(65.0)
        random.add(72.0)
        random.add(63.0)
        random.add(80.0)
        random.add(88.0)
        random.add(95.0)
        random.add(100.0)
        return random
    } fun randomData2(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(0.0)
        random.add(50.0)
        random.add(40.0)
        random.add(60.0)
        random.add(20.0)
        random.add(30.0)
        random.add(10.0)
        random.add(40.0)
        random.add(60.0)
        random.add(50.0)
        random.add(55.0)
        random.add(90.0)
        random.add(65.0)
        random.add(70.0)
        random.add(80.0)
        random.add(85.0)
        random.add(20.0)
        return random
    } fun randomData3(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(100.0)
        random.add(90.0)
        random.add(80.0)
        random.add(10.0)
        random.add(60.0)
        random.add(10.0)
        random.add(20.0)
        random.add(30.0)
        random.add(40.0)
        random.add(50.0)
        random.add(55.0)
        random.add(50.0)
        random.add(45.0)
        random.add(30.0)
        random.add(90.0)
        random.add(85.0)
        random.add(10.0)
        return random
    } fun randomData4(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(100.0)
        random.add(60.0)
        random.add(30.0)
        random.add(10.0)
        random.add(20.0)
        random.add(70.0)
        random.add(90.0)
        random.add(30.0)
        random.add(40.0)
        random.add(50.0)
        random.add(55.0)
        random.add(60.0)
        random.add(45.0)
        random.add(70.0)
        random.add(30.0)
        random.add(85.0)
        random.add(20.0)
        return random
    } fun randomData5(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(100.0)
        random.add(90.0)
        random.add(80.0)
        random.add(70.0)
        random.add(30.0)
        random.add(20.0)
        random.add(30.0)
        random.add(40.0)
        random.add(50.0)
        random.add(60.0)
        random.add(65.0)
        random.add(10.0)
        random.add(95.0)
        random.add(30.0)
        random.add(20.0)
        random.add(35.0)
        random.add(20.0)
        return random
    } fun randomData6(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(100.0)
        random.add(20.0)
        random.add(30.0)
        random.add(40.0)
        random.add(60.0)
        random.add(50.0)
        random.add(40.0)
        random.add(30.0)
        random.add(40.0)
        random.add(50.0)
        random.add(65.0)
        random.add(10.0)
        random.add(25.0)
        random.add(30.0)
        random.add(40.0)
        random.add(15.0)
        random.add(20.0)
        return random
    } fun randomData7(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(30.0)
        random.add(20.0)
        random.add(10.0)
        random.add(20.0)
        random.add(30.0)
        random.add(60.0)
        random.add(30.0)
        random.add(80.0)
        random.add(49.0)
        random.add(59.0)
        random.add(57.0)
        random.add(63.0)
        random.add(62.0)
        random.add(73.0)
        random.add(81.0)
        random.add(86.0)
        random.add(12.0)
        return random
    } fun randomData8(): ArrayList<Double> {
        val random = ArrayList<Double>()
        random.add(10.0)
        random.add(95.0)
        random.add(85.0)
        random.add(75.0)
        random.add(65.0)
        random.add(54.0)
        random.add(42.0)
        random.add(33.0)
        random.add(42.0)
        random.add(51.0)
        random.add(52.0)
        random.add(62.0)
        random.add(69.0)
        random.add(72.0)
        random.add(80.0)
        random.add(85.0)
        random.add(15.0)
        return random
    }
}
