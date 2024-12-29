package com.example.task3_10;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main);

        tv = findViewById(R.id.tv_result);
        iv = findViewById(R.id.iv_result);
        lv = findViewById(R.id.listview);
        Spinner sp = findViewById(R.id.spinner);

        String[] strCities = new String[]{"杭州","宁波","温州"};

        List<City> cities = new ArrayList<>();
        List<Sight> sights_hz = new ArrayList<>();
        sights_hz.add(new Sight("lingyinsi",R.drawable.lingyinsi));
        sights_hz.add(new Sight("qiandaohu",R.drawable.qiandaohu));
        sights_hz.add(new Sight("wuzhen",R.drawable.wuzhen));
        sights_hz.add(new Sight("xihu",R.drawable.xihu));

        List<Sight> sights_nb = new ArrayList<>();
        sights_nb.add(new Sight("laowaitan",R.drawable.laowaitan));
        sights_nb.add(new Sight("tianyige",R.drawable.tianyige));
        sights_nb.add(new Sight("xiangshanyingshicheng",R.drawable.xiangshanyingshicheng));
        sights_nb.add(new Sight("xikoufengjingqu",R.drawable.xikoufengjingqu));

        List<Sight> sights_wz = new ArrayList<>();
        sights_wz.add(new Sight("jiangxinyu",R.drawable.jiangxinyu));
        sights_wz.add(new Sight("lishuigujie",R.drawable.lishuigujie));
        sights_wz.add(new Sight("yandangshan",R.drawable.yandangshan));
        sights_wz.add(new Sight("yinxiangnantang",R.drawable.yinxiangnantang));

        cities.add(new City("杭州",R.drawable.hangzhou,sights_hz));
        cities.add(new City("宁波",R.drawable.ningbo,sights_nb));
        cities.add(new City("温州",R.drawable.wenzhou,sights_wz));

//        创建适配器填充spinner下拉列表的视图
        ArrayAdapter<String> spAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,strCities);
        sp.setAdapter(spAdapter);

//        设置sp下拉列表点击侦听事件
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                更新listview内容
//                获取当前选中的城市
                City city = cities.get(position);
                updateListView(city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


//    更新列表视图
    private void updateListView(City city) {
//    获取当前选中城市的景点集合
        List<Sight> sights = city.getSights();
//        生成listview视图并渲染数据
        SightAdapter sightAdapter = new SightAdapter(MainActivity.this,sights);
        lv.setAdapter(sightAdapter);
//        更新tv_result
        Sight defaultSight = sights.get(0);
        tv.setText(city.getName() + "：" + defaultSight.getName());
        iv.setImageResource(defaultSight.getPicId());
//        设置listview点击侦听事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sight sight = sights.get(position);
                tv.setText(city.getName() + "：" + sight.getName());
                iv.setImageResource(sight.getPicId());
            }
        });
    }
}