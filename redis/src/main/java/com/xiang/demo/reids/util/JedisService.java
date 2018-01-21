package com.xiang.demo.reids.util;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

@Service
public class JedisService {

	private static final Logger logger = LoggerFactory.getLogger(JedisService.class);

	@Autowired
	private JedisPool jedisPool;

	@Value("${redis.host}")
	private String ip;// IP地址

	@Value("${redis.port}")
	private int port = 6379;// 端口

	@Value("${redis.timeout}")
	private int timeout;// 超时时间(毫秒)

	@Value("${redis.password}")
	private String password;// 密码

	@Value("${redis.database}")
	private int database;// 数据库索引

	@Value(value = "${redis.maxIdle}")
	private int maxIdle;

	@Value(value = "${redis.maxTotal}")
	private int maxTotal;

	@Value(value = "${redis.maxWaitMillis}")
	private long maxWaitMillis;

	@Value(value = "${redis.testOnBorrow}")
	private boolean testOnBorrow;
	
	public JedisService() {}
	
	/**
	 * 构造实例
	 * 
	 * @param ip
	 *            IP地址
	 * @param port
	 *            端口
	 * @param database
	 *            数据库索引
	 */
	public JedisService(String ip, int port, int database) {
		this.ip = ip;
		this.port = port;
		this.database = database;
	}

	public JedisService(String ip, int port, int timeout, String password, int database) {
		this.ip = ip;
		this.port = port;
		this.timeout = timeout;
		this.password = password;
		this.database = database;
	}

	public boolean open() {
		boolean ret = false;
		close();
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(maxTotal);
			config.setMaxIdle(maxIdle);
			config.setMaxWaitMillis(maxWaitMillis);
			config.setTestOnBorrow(testOnBorrow);
			jedisPool = new JedisPool(config, ip, port, timeout, password, database);
			ret = true;
		} catch (Exception e) {
			logger.error("失败", e);
		}
		logger.info("Open " + (ret ? "SUCCESS" : "FAIL") + ".");
		if (!ret)
			close();
		return ret;
	}

	public void close() {
		try {
			if (jedisPool != null) {
				jedisPool.destroy();
				logger.info("Close.");
			}
		} catch (Exception e) {
		}
		jedisPool = null;
	}

	public Jedis getResource() {
		Jedis ret = null;
		try {
			ret = jedisPool.getResource();
		} catch (Exception e) {
			logger.error("获取jedis失败", e);
		}	
		return ret;
	}

	public void release(Jedis jedis) {
		try {
			if (jedis != null) {
				jedis.close();
			}
		} catch (Exception e) {
			logger.error("释放资源失败", e);
		}
	}

	/**
	 * 设置生存期
	 * 
	 * @param key
	 *            键
	 * @param seconds
	 *            生存期(秒)
	 */
	public Long expire(String key, int seconds) {
		Jedis jedis = getResource();
		Long result = null;
		try {
			result = jedis.expire(key, seconds);
		} catch (JedisConnectionException e) {
			logger.error("设置生存期失败 {}", key, e);
		} catch (Exception e) {
			logger.error("设置生存期失败 {}", key, e);
		}
		release(jedis);
		return result;
		
	}

	/**
	 * 删除键
	 * 
	 * @param keys
	 *            键
	 * @return 
	 */
	public Long del(String... keys) {
		Jedis jedis = getResource();
		Long result = null;
		try {
			result = jedis.del(keys);
		} catch (JedisConnectionException e) {
			logger.error("删除键失败{},{}", keys, e);
		} catch (Exception e) {
			logger.error("删除键失败{},{}", keys, e);
		}
		release(jedis);
		return result;
	}

	/**
	 * 字符串-存入
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public String stringSet(String key, String value) {
		Jedis jedis = getResource();
		String result = null;
		try {
			result = jedis.set(key, value);
		} catch (JedisConnectionException e) {
			logger.error("字符串-存入失败", e);
		} catch (Exception e) {
			logger.error("字符串-存入失败", e);
		}
		release(jedis);
		return result;
	}

	/**
	 * 字符串-获取
	 * 
	 * @param key
	 *            键
	 * @return 值
	 */
	public String stringGet(String key) {
		String ret = null;
		Jedis jedis = getResource();
		try {
			ret = jedis.get(key);
		} catch (JedisConnectionException e) {
			logger.error("字符串-存入, 失败", e);
		} catch (Exception e) {
			logger.error("字符串-获取, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 哈希表-设置域值
	 * 
	 * @param key
	 *            键
	 * @param field
	 *            域
	 * @param value
	 *            值
	 */
	public Long hashSet(String key, String field, String value) {
		Jedis jedis = getResource();
		Long result = null;
		try {
			result = jedis.hset(key, field, value);
		} catch (JedisConnectionException e) {
			logger.error("哈希表-设置域值, 失败", e);
		} catch (Exception e) {
			logger.error("哈希表-设置域值, 失败", e);
		}
		release(jedis);
		return result;
	}

	/**
	 * 哈希表-获取域值
	 * 
	 * @param key
	 *            键
	 * @param field
	 *            域
	 * @return 域值
	 */
	public String hashGet(String key, String field) {
		String ret = null;
		Jedis jedis = getResource();
		try {
			ret = jedis.hget(key, field);
		} catch (JedisConnectionException e) {
			logger.error("哈希表-获取域值, 失败", e);
		} catch (Exception e) {
			logger.error("哈希表-获取域值, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 哈希表-删除
	 * 
	 * @param key
	 *            键
	 * @param fields
	 *            域
	 * @return 
	 */
	public Long hashDel(String key, String... fields) {
		Jedis jedis = getResource();
		Long result = null;
		try {
			result = jedis.hdel(key, fields);
		} catch (JedisConnectionException e) {
			logger.error("哈希表-删除, 失败", e);
		} catch (Exception e) {
			logger.error("哈希表-删除, 失败", e);
		}
		release(jedis);
		return result;
	}

	/**
	 * 哈希表-域数量
	 * 
	 * @param key
	 *            键
	 * @return 域数量
	 */
	public long hashSize(String key) {
		long ret = 0;

		Jedis jedis = getResource();
		try {
			ret = jedis.hlen(key);
		} catch (JedisConnectionException e) {
			logger.error("哈希表-域数量, 失败", e);
		} catch (Exception e) {
			logger.error("哈希表-域数量, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 哈希表-域集合
	 * 
	 * @param key
	 *            键
	 * @return 域集合
	 */
	public Set<String> hashFields(String key) {
		Set<String> ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.hkeys(key);
		} catch (JedisConnectionException e) {
			logger.error("哈希表-域集合, 失败", e);
		} catch (Exception e) {
			logger.error("哈希表-域集合, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 哈希表-域值列表
	 * 
	 * @param key
	 *            键
	 * @return 域值列表
	 */
	public List<String> hashValues(String key) {
		List<String> ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.hvals(key);
		} catch (JedisConnectionException e) {
			logger.error("哈希表-域集合, 失败", e);
		} catch (Exception e) {
			logger.error("哈希表-域集合, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 哈希表-增加域值
	 * 
	 * @param key
	 *            键
	 * @param field
	 *            域
	 * @param value
	 *            增值
	 * @return 域值
	 */
	public Long hashIncr(String key, String field, long value) {
		long ret = 0;

		Jedis jedis = getResource();
		try {
			ret = jedis.hincrBy(key, field, value);
		} catch (JedisConnectionException e) {
			logger.error("哈希表-增加域值, 失败", e);
		} catch (Exception e) {
			logger.error("哈希表-增加域值, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 列表-添加
	 * 
	 * @param key
	 *            键
	 * @param values
	 *            值
	 */
	public Long lpush(String key, String... values) {
		Long resu = null;
		Jedis jedis = getResource();
		try {
			resu = jedis.lpush(key, values);
		} catch (JedisConnectionException e) {
			logger.error("列表-添加, 失败", e);
		} catch (Exception e) {
			logger.error("列表-添加, 失败", e);
		}
		release(jedis);
		return resu;
	}

	/**
	 * 列表-获取
	 * 
	 * @param key
	 *            键
	 * @return 值
	 */
	public String rpop(String key) {
		String ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.rpop(key);
		} catch (JedisConnectionException e) {
			logger.error("列表-获取, 失败", e);
		} catch (Exception e) {
			logger.error("列表-获取, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 列表-添加
	 * 
	 * @param key
	 *            键
	 * @param values
	 *            值
	 */
	public Long rpush(String key, String... values) {
		Long result = null;
		Jedis jedis = getResource();
		try {
			jedis.rpush(key, values);
		} catch (JedisConnectionException e) {
			logger.error("列表-添加, 失败", e);
		} catch (Exception e) {
			logger.error("列表-添加, 失败", e);
		}
		release(jedis);
		return result;
	}

	/**
	 * 列表-设置
	 * 
	 * @param key
	 *            键
	 * @param index
	 *            索引
	 * @param value
	 *            值
	 * @return 
	 */
	public String lset(String key, long index, String value) {
		String result = null;
		Jedis jedis = getResource();
		try {
			result = jedis.lset(key, index, value);
		} catch (JedisConnectionException e) {
			logger.error("列表-设置, 失败", e);
		} catch (Exception e) {
			logger.error("列表-设置, 失败", e);
		}
		release(jedis);
		return result;
	}

	/**
	 * 列表-数量
	 * 
	 * @param key
	 *            键
	 * @return 数量
	 */
	public Long llen(String key) {
		Long ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.llen(key);
		} catch (JedisConnectionException e) {
			logger.error("列表-数量, 失败", e);
		} catch (Exception e) {
			logger.error("列表-数量, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 列表-获取指定区间内的记录
	 * 
	 * @param key
	 *            键
	 * @param start
	 *            起始偏移(0表示第一条)
	 * @param end
	 *            结束偏移(-1表示最后一条)
	 * @return 记录列表
	 */
	public List<String> lrange(String key, long start, long end) {
		List<String> ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.lrange(key, start, end);
		} catch (JedisConnectionException e) {
			logger.error("列表-获取指定区间内的记录, 失败", e);
		} catch (Exception e) {
			logger.error("列表-获取指定区间内的记录, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 列表-删除指定值的记录
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public Long lrem(String key, String value) {
		Long ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.lrem(key, 0, value);
		} catch (JedisConnectionException e) {
			logger.error("列表-删除指定值的记录, 失败", e);
		} catch (Exception e) {
			logger.error("列表-删除指定值的记录, 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 列表-删除指定区间外的记录
	 * 
	 * @param key
	 *            键
	 * @param start
	 *            起始偏移(0表示第一条)
	 * @param end
	 *            结束偏移(-1表示最后一条)
	 */
	public String ltrim(String key, long start, long end) {
		String result = null;
		Jedis jedis = getResource();
		try {
			result = jedis.ltrim(key, start, end);
		} catch (JedisConnectionException e) {
			logger.error("列表-删除指定区间外的记录， 失败", e);
		} catch (Exception e) {
			logger.error("列表-删除指定区间外的记录， 失败", e);
		}
		release(jedis);
		return result;
	}

	/**
	 * 有序集合-更新记录
	 * 
	 * @param key
	 *            键
	 * @param score
	 *            权重
	 * @param member
	 *            成员
	 */
	public void zrangeByScore(String key, String score, String member) {

		Jedis jedis = getResource();
		try {
			Set<String> list = jedis.zrangeByScore(key, score, score);
			if ((list != null) && (list.contains(member)))
				jedis.zremrangeByScore(key, score, score);
			jedis.zadd(key, Double.parseDouble(score), member);
		} catch (JedisConnectionException e) {
			logger.error("有序集合-更新记录， 失败", e);
		} catch (Exception e) {
			logger.error("有序集合-更新记录， 失败", e);
		}
		release(jedis);
	}

	/**
	 * 有序集合-删除记录
	 * 
	 * @param key
	 *            键
	 * @param start
	 *            起始权重
	 * @param end
	 *            结束权重
	 */
	public void sortedSetDel(String key, String start, String end) {

		Jedis jedis = getResource();
		try {
			jedis.zremrangeByScore(key, start, end);
		} catch (JedisConnectionException e) {
			logger.error("有序集合-删除记录， 失败", e);
		} catch (Exception e) {
			logger.error("有序集合-删除记录， 失败", e);
		}
		release(jedis);
	}

	/**
	 * 有序集合-获取指定区间内记录(递增)
	 * 
	 * @param key
	 *            键
	 * @param min
	 *            最小权重
	 * @param max
	 *            最大权重
	 * @return 记录集合(递增)
	 */
	public Set<String> sortedSetGetByScore(String key, String min, String max) {
		Set<String> ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.zrangeByScore(key, min, max);
		} catch (JedisConnectionException e) {
			logger.error("有序集合-获取指定区间内记录(递增)， 失败", e);
		} catch (Exception e) {
			logger.error("有序集合-获取指定区间内记录(递增)， 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 有序集合-获取指定区间内记录(递增)
	 * 
	 * @param key
	 *            键
	 * @param min
	 *            最小权重
	 * @param max
	 *            最大权重
	 * @param offset
	 *            偏移
	 * @param count
	 *            数量
	 * @return 记录集合(递增)
	 */
	public Set<String> sortedSetGetByScore(String key, String min, String max, int offset, int count) {
		Set<String> ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.zrangeByScore(key, min, max, offset, count);
		} catch (JedisConnectionException e) {
			logger.error("有序集合-获取指定区间内记录(递增)， 失败", e);
		} catch (Exception e) {
			logger.error("有序集合-获取指定区间内记录(递增)， 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 有序集合-获取指定区间内记录(递减)
	 * 
	 * @param key
	 *            键
	 * @param min
	 *            最小权重
	 * @param max
	 *            最大权重
	 * @return 记录集合(递减)
	 */
	public Set<String> sortedSetGetByScoreRev(String key, String max, String min) {
		Set<String> ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.zrevrangeByScore(key, max, min);
		} catch (JedisConnectionException e) {
			logger.error("序集合-获取指定区间内记录(递减)， 失败", e);
		} catch (Exception e) {
			logger.error("序集合-获取指定区间内记录(递减)， 失败", e);
		}
		release(jedis);
		return ret;
	}

	/**
	 * 有序集合-获取指定区间内记录(递减)
	 * 
	 * @param key
	 *            键
	 * @param min
	 *            最小权重
	 * @param max
	 *            最大权重
	 * @param offset
	 *            偏移
	 * @param count
	 *            数量
	 * @return 记录集合(递减)
	 */
	public Set<String> sortedSetGetByScoreRev(String key, String max, String min, int offset, int count) {
		Set<String> ret = null;

		Jedis jedis = getResource();
		try {
			ret = jedis.zrevrangeByScore(key, max, min, offset, count);
		} catch (JedisConnectionException e) {
			logger.error("有序集合-获取指定区间内记录(递减)， 失败", e);
		} catch (Exception e) {
			logger.error("有序集合-获取指定区间内记录(递减), 失败", e);
		}
		release(jedis);
		return ret;
	}

}
