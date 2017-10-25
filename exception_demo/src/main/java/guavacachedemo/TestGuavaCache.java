package guavacachedemo;

/**
 * Created by jack on 2017/10/20.
 */

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestGuavaCache {

    public static void main(String[] agrs) throws ExecutionException, InterruptedException {
        // 模拟数据
        final List<Person> list = new ArrayList<>(5);
        list.add(new Person("1", "zhangsan"));
        list.add(new Person("2", "lisi"));
        list.add(new Person("3", "wangwu"));

        // 创建cache
        LoadingCache<String, Person> cache = CacheBuilder.newBuilder()//
                .refreshAfterWrite(5000, TimeUnit.MILLISECONDS)// 给定时间内没有被读/写访问，则回收。
                // .expireAfterWrite(5, TimeUnit.SECONDS)//给定时间内没有写访问，则回收。
                // .expireAfterAccess(3, TimeUnit.SECONDS)// 缓存过期时间为3秒
                .maximumSize(100).// 设置缓存个数
                build(new CacheLoader<String, Person>() {

            /**  当本地缓存命没有中时，调用load方法获取结果并将结果缓存
             */
            @Override
            public Person load(String key) throws ExecutionException {
                System.out.println(key + " load in cache");
                return getPerson(key);
            }

            // 此时一般我们会进行相关处理，如到数据库去查询
            private Person getPerson(String key) throws ExecutionException {
                System.out.println(key + " query");
                for (Person p : list) {
                    if (p.getId().equals(key))
                        return p;
                }
                return null;
            }

            @Override
            public ListenableFuture<Person> reload(final String key,
                                                   Person person) {
                ListenableFutureTask<Person> task = ListenableFutureTask.create(new Callable<Person>() {

                    @Override
                    public Person call() {
                        System.out.println("reload method is being called!!!");
                        return new Person("a","persona");
                    }
                });

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(task);
                return task;
            }

        });

        for(int i = 0;i < 5;i++){
            System.out.println(cache.get("1"));
            System.out.println(cache.get("2"));
            System.out.println(cache.get("3"));
            Thread.sleep(4000);
        }
        System.out.println("last time");
        System.out.println(cache.get("1"));
        System.out.println(cache.get("2"));
        System.out.println(cache.get("3"));
    }
}
