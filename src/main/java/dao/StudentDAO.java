package dao;

import entity.Student;
import redis.clients.jedis.Jedis;
import util.JedisUtil;
import util.SerializeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class StudentDAO {
    private static final String ipAddr = "120.79.150.180";
    private static final int port = 6379;
    private static Jedis jedis= null;
    public static void init()
    {
        jedis = JedisUtil.getInstance().getJedis(ipAddr, port);
    }
    public static void close()
    {
        JedisUtil.getInstance().closeJedis(jedis,ipAddr, port);
    }
    public void setObject(Student student) throws ParseException {
        init();
        jedis.set(("sutdent:"+student.getId()).getBytes(), SerializeUtil.serialize(student));
        close();
    }
    public Student getObject(String id) {
        init();
        byte[] student = jedis.get(("sutdent:" + id).getBytes());
        close();
        return (Student) SerializeUtil.unserialize(student);
    }
    private String  avgscoure="avgkey";
    public void setSet(String id,double avg){
    	init();
    	jedis.zadd(avgscoure,avg, id);
    	close();
    }
    public Set<String> getSet(int page){
    	int pageCount =10;
    	init();
    	Set<String> idSort=jedis.zrevrange(avgscoure, (page-1)*pageCount, page*pageCount-1);
    	close();
    	return idSort;
    }
    public void delObject(String id) throws ParseException {
        init();
        jedis.del("sutdent:"+id);
        jedis.zrem(avgscoure,id);
        close();
    }
}
