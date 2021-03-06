package zrkc.group.utils.BaseUtils;

import java.io.*;
import java.util.Iterator;

//import com.sun.tools.javac.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;

public class JsonBaseUtil {

    /**
     * json读取
     * @param path json路径
     * @param name json文件名
     * @param keyWord 搜索的信息
     * @return
     *          str --搜索的jsonArray
     */

    public static JSONArray JsonSearch(String path, String name, String keyWord) throws Exception{
        JSONArray jsonArray = null;
        String filename = path + "\\" + name + ".json";
        try{
            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            String str = FileUtils.readFileToString(file,"UTF-8");
            JSONObject jsonObject = JSONObject.fromObject(str);
            if(jsonObject != null){
                jsonArray = jsonObject.getJSONArray(keyWord);
            }
        }catch (IOException e){
            throw new Exception("");
        }
        return jsonArray;
    }


    /**
     * 转换object至json字符串
     * @param object
     * @return
     */
    public static String ObjtoSting(Object object)throws Exception {
        if(object == null)
            return null;
        String str = null;
        try {
            JSONArray jsonArray = JSONArray.fromObject(object);
            str = jsonArray.toString();
//            class
//            private int data;
        }catch (Exception e){
            throw new Exception("类型转换失败");
        }
        return str.substring(1, str.length()-1);
    }

    /**
     * 对jsonobj对象中键为key的jsonarr添加一个value的jsonobj对象
     * @param obj jsonobj对象
     * @param key 关键字
     * @param value Obj对象
     */

    public static void addDataInArr(JSONObject obj, String key, Object value){
        JSONArray array = obj.getJSONArray(key);
        array.add(value);
    }

    /**
     * 对json对象obj中键为key的json数组A
     * 删除A中键-值为skey-(Object)value的一个json对象
     * @param obj json对象
     * @param key 获得arr数组
     * @param skey key关键字
     * @param value 值
     */

    public static void delDataInArr(JSONObject obj, String key, String skey, Object value){
        JSONArray array = obj.getJSONArray(key);
        Iterator iter = array.iterator();
        while(iter.hasNext()){
            JSONObject element = (JSONObject) iter.next();
            if(element.get(skey) == value){
                array.remove(element);
            }
        }
    }

//    public static Map<String, String> parseJSON2Map(JSONArray json) {
//        Map<String, String> tables = new HashMap<String, String>();
//        Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
//        if(json.size() == 1){
//            tables.put(json.op)
//            return
//        }
//        for(Object key: json.keySet()) {
//            JSONObject value = json.getJSONObject(key.toString());
//            String table = (String)JSONObject.toBean(value, String.class, classMap);
//            tables.put(key.toString(), table);
//        }
//
//        return tables;
//    }



}
