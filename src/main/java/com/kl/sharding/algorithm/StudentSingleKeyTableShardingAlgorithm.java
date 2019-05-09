package com.kl.sharding.algorithm;
 import java.util.Collection;  
import java.util.LinkedHashSet;  
  
import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;  
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;  
import com.google.common.collect.Range;  

public class StudentSingleKeyTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<String>{
  
    /** 
     * sql 中 = 操作时，table的映射 
     */  
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        String key =shardingValue.getValue();
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (tableNames.size() - 1) & hash;
        for (String each : tableNames) {
            if (each.endsWith(("0".concat(String.valueOf(index))))) {
                return each;
            }
        }
        throw new IllegalArgumentException();  
    }  
  
    /** 
     * sql 中 in 操作时，table的映射 
     */  
    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(tableNames.size());
        String key =shardingValue.getValue();
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (tableNames.size() - 1) & hash;
        for (String value : shardingValue.getValues()) {
            for (String tableName : tableNames) {
                if (tableName.endsWith(("0".concat(String.valueOf(index))))) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }  
  
    /** 
     * sql 中 between 操作时，table的映射 
     */  
    public Collection<String> doBetweenSharding(Collection<String> tableNames,  
            ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(tableNames.size());
        String key =shardingValue.getValue();
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int index = (tableNames.size() - 1) & hash;
        for (String each : tableNames) {
            if (each.endsWith(("0".concat(String.valueOf(index))))) {
                result.add(each);
            }
        }
        return result;
    }  
  
}  