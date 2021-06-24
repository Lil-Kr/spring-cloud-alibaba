package com.cy.redisserver018020.config.redis;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: 烟幕
 * @Date: 2021/5/22
 * @Description:
 */
@Component
public class RedisServer<T,K,V> {

    @Resource
    private RedisTemplate redisTemplate1;

    /**
     * 判断key的类型
     * @param key
     * @return
     */
    public String keyType(String key) {
        return redisTemplate1.type(key).code();
    }

    /**
     * 判断1个或多个key是否存在
     * @param keys
     * @return
     */
    public Long keyExists(Collection<String> keys) {
        return redisTemplate1.countExistingKeys(keys);
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public Boolean deleteKey(String key) {
        return redisTemplate1.delete(key);
    }

    /**
     * 删除一组keys
     * @param keys
     * @return
     */
    public Long deleteKeys(Collection<String> keys) {
        return redisTemplate1.delete(keys);
    }


    /**============ Type String ==============**/
    /**
     *
     * @param key
     * @param value
     */
    public void setRediskv(String key,String value){
        ValueOperations<String, String> forValue = redisTemplate1.opsForValue();
        forValue.set(key,value);
    }

    public T getRediskv(String key) {
        return (T) redisTemplate1.opsForValue().get(key);
    }

    public boolean setNx(String key,String value) {
        return redisTemplate1.opsForValue().setIfAbsent(key, value);
    }

//    public void setEx() {
//        redisTemplate1.opsForValue().set();
//    }

    /**
     * 批量插入kv
     * @param map
     */
    public void setRedisMultikv(HashMap<String,String> map) {
        redisTemplate1.opsForValue().multiSet(map);
    }

    /**============ Type Hash ==============**/

    public Boolean setRedisHash(String key, String field,String value) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate1.opsForHash();
        return hashOperations.putIfAbsent(key, field, value);
    }

    public String getRedisHash(String key, String field) {

        return String.valueOf(redisTemplate1.opsForHash().get(key, field));
    }

    /**============ Type List ==============**/
    // TODO  Type List
    public void pushReidsList() {
        ListOperations<String, String> listOperations = redisTemplate1.opsForList();
//        listOperations.leftPush();
    }

    public List<T> getRangList(String key, long start, long end) {
        ListOperations<String, String> listOperations = redisTemplate1.opsForList();
        List<T> range = (List<T>) listOperations.range(key, start, end);
        return range;
    }

    /**============ Type Set ==============**/
    /**
     * Set添加元素
     * example SADD set1 a b c d e f g
     * @param key
     * @param v
     * @return 添加本次元素的个数
     */
    public Long addSet(String key, String... v) {
        SetOperations<String, String> setOperations = redisTemplate1.opsForSet();
        Long add = setOperations.add(key, v);
        return add;
    }

    /**
     * 返回Set中的一个随机数
     * @param key key
     * @return t
     */
    public T getSetRandmember(String key) {
        SetOperations<String, String> setOperations = redisTemplate1.opsForSet();
        T t = (T) setOperations.randomMember(key);
        return t;
    }

    /**
     * 返回Set中的一组随机数
     * @param key key
     * @param number 需要返回的数量
     * @return List
     */
    public List<T> getSetRandmembers(String key,long number) {
        SetOperations<String, String> setOperations = redisTemplate1.opsForSet();
        List<T> list = (List<T>) setOperations.randomMembers(key, number);
        return list;
    }

    public T popSet(String key){
        return (T) redisTemplate1.opsForSet().pop(key);
    }

    public List<T> popSets(String key, long number){
        List<T> pops = (List<T>) redisTemplate1.opsForSet().pop(key, number);
        return pops;
    }

    /**
     * 返回Set集合中的元素
     * @param key
     * @return
     */
    public Long getSetNumbers(String key){
        return redisTemplate1.opsForSet().size(key);
    }

    /**
     * 返回指定集合中的所有元素
     * @param key
     * @return
     */
    public Set<T> getAllSet(String key){
        Set<T> members = (Set<T>) redisTemplate1.opsForSet().members(key);
        return members;
    }

    /**============ Type Zset ==============**/
    /**
     * 添加zset元素
         Set<DefaultTypedTuple<String>> v = new HashSet<>();
         for (int i = 0; i < 10; i++) {
         v.add(new DefaultTypedTuple<String>("redis" + i, (double) i));
         }
     *
     * @param key
     * @param v
     */
    public Long addZset(String key,Set<ZSetOperations.TypedTuple<String>> v) {
        return redisTemplate1.opsForZSet().add(key, v);
    }

    /**
     * 计算有序集合中指定分数区间的成员数量
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long getCountZset(String key,long min,long max) {
        return redisTemplate1.opsForZSet().count(key,min,max);
    }

    /**
     * 返回有序集中, 指定区间内的成员
     * @param k
     * @param start
     * @param end
     */
    public Set<String> getListByRange(String k,long start,long end) {
        return redisTemplate1.opsForZSet().range(k, start, end);
    }

}
