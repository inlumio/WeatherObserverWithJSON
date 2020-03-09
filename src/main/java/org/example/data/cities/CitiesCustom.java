package org.example.data.cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitiesCustom {

    private static Map<Integer, List<String>> cities;

    private CitiesCustom(){  }

    public static  Map<Integer, List<String>> citiesData(){

        cities = new HashMap<>();

        cities.put(1, new ArrayList<String>(){{ add("Kyiv(Ukraine)"); add("703448"); }});
        cities.put(2, new ArrayList<String>(){{ add("Dnipro(Ukraine)"); add("709930"); }});
        cities.put(3, new ArrayList<String>(){{ add("Odessa(Ukraine)"); add("698740"); }});
        cities.put(4, new ArrayList<String>(){{ add("Lviv(Ukraine)"); add("702550"); }});
        cities.put(5, new ArrayList<String>(){{ add("London(Great Britain)"); add("2643743"); }});
        cities.put(6, new ArrayList<String>(){{ add("Moscow(Russia)"); add("524901"); }});
        cities.put(7, new ArrayList<String>(){{ add("Berlin(Germany)"); add("2950159"); }});
        cities.put(8, new ArrayList<String>(){{ add("Dublin(Ireland)"); add("2964574"); }});
        cities.put(9, new ArrayList<String>(){{ add("Minsk(Belarus)"); add("625144"); }});
        cities.put(10, new ArrayList<String>(){{ add("Warsaw(Poland)"); add("756135"); }});

        return cities;
    }

}
