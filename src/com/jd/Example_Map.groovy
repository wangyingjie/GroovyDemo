package com.jd

class Example_Map {

    static void main(String[] args) {

        def mp = ["TopicName": "Maps", "TopicDescription": "Methods in Maps"]
        println mp.containsKey("TopicName");
        println mp.containsKey("Topic");

        println(mp.get("TopicName"));
        println(mp.get("Topic"));

        mp.put("TopicID","1");
        println(mp);

        println(mp.values());
    }

}
