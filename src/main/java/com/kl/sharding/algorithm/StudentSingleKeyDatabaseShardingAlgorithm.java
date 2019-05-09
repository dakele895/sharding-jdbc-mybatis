package com.kl.sharding.algorithm;
import java.util.Collection;  
import java.util.LinkedHashSet;  
  
import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;  
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;  
import com.google.common.collect.Range;  
  

public class StudentSingleKeyDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String>{
  
    /** 
     * sql 中关键字 匹配符为 =的时候，表的路由函数 
     */  
	@Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        String key =shardingValue.getValue();
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (availableTargetNames.size() - 1) & hash;
        for (String each : availableTargetNames) {
            if (each.endsWith(index + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }  
  
    /** 
     * sql 中关键字 匹配符为 in 的时候，表的路由函数 
     */
	@Override
    public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());
        String key =shardingValue.getValue();
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (availableTargetNames.size() - 1) & hash;
        for (String value : shardingValue.getValues()) {
            for (String tableName : availableTargetNames) {
                if (tableName.endsWith(index + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;

    }  
  
    /** 
     * sql 中关键字 匹配符为 between的时候，表的路由函数 
     */  
	@Override
    public Collection<String> doBetweenSharding(Collection<String> availableTargetNames,  
            ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());
        String key =shardingValue.getValue();
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (availableTargetNames.size() - 1) & hash;
        Range<String> range = (Range<String>) shardingValue.getValueRange();
        for (String each : availableTargetNames) {
            if (each.endsWith(index + "")) {
                result.add(each);
            }
        }

        return result;
    }  
  
}  