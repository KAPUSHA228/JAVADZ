package com.example.demo;
import com.google.gson.*;
import java.lang.reflect.Type;
public class TimeAdapter implements JsonSerializer<Time>, JsonDeserializer<Time>{
        @Override
        public JsonElement serialize(Time clock, Type type, JsonSerializationContext context) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("hour", clock.toGet_Hour());
            jsonObject.addProperty("min", clock.toGet_Min());
            jsonObject.addProperty("cost", clock.toGet_Cost());
            jsonObject.addProperty("mark", clock.toGet_Mark());
            jsonObject.addProperty("ID", clock.toGet_ID());
            jsonObject.addProperty("type",clock.toGet_Type());
            if(clock.toGet_Type().equals("HMS"))
                jsonObject.addProperty("sec", clock.toGet_Sec());
            return jsonObject;
        }
        @Override
        public Time deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            int hour = jsonObject.get("hour").getAsInt();
            int min = jsonObject.get("min").getAsInt();
            Time t;
            int cost = jsonObject.get("cost").getAsInt();
            String mark = jsonObject.get("mark").getAsString();
            int id = jsonObject.get("ID").getAsInt();
            if(jsonObject.get("type").getAsString().equals("HMS"))
            {   int sec = jsonObject.get("sec").getAsInt();
                return t=new Clock2(mark, cost,hour, min, sec,id);}
            else {return t=new Clock(mark, cost,hour, min,id);}
        }
}