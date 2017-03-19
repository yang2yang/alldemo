package produceconsumedemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * *  author:jack 2017年03月2017/3/19日
 */

/**
 * Meal是临界变量
 * 刚开始没有meal，所以waiterPerson一直等待(等待的时候，需要加上this或者说waitPerson的锁,但是也没有规定一定要上this的锁)
 * chef生产出了meal之后，就会通知waitPerson(通知的时候就需要加上waitPerson的锁)
 * 只有一个生产者和消费者，所以不会有多个消费者消费同一个的情况??
 */
public class Restaurant {
    public Meal meal;

    ExecutorService exec = Executors.newCachedThreadPool();

    public WaitPerson waitPerson = new WaitPerson(this);

    public Chef chef = new Chef(this);

    public Restaurant(){
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

/**
 * Meal
 */
class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

/**
 * 侍者,消费者
 */
class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
//                    notifyAll();
                    //直接notifyAll()是不对的
                    // 在哪一个对象上面调用notifyAll(),那么就会唤醒其他拥有??
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

/**
 * 厨师,生产者
 */
class Chef implements Runnable {

    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                //为什么这里要锁住自己啊?
                //锁住自己的概念就是当前线程拥有了这个对象，其他线程无法获得访问这个对象了?不是，只有当其他线程同步方法想要获得这个对象的时候，会阻塞
                //这里锁住自身没有任何用处把?因为就只有自己一个线程，本线程对临界变量肯定不会操作，所以只有对方的线程进行操作
                //然后有一个约定是对象线程操作的时候，会锁住我这个对象，所以这里还是应该锁住自身这个对象
                //所以这里最后的结论就是另一个线程，进行操作改变的时候会锁住哪一个对象，那么我进行判断的时候也锁住哪一个对象就好了
                //但是下面的又该怎么解释呢?

                //因为调用wait的时候必须在同步发方法块中
                synchronized (this){
                    while(restaurant.meal != null){
                        wait();
                    }
                }
                //如果数量达到了10了之后，食物就使用完了
                if(++count == 10){
                    System.out.println("count = "+ count);
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up!");
                //为什么这里要锁住waitPerson这个对象呢?不用锁住waitPerson的把，waitPerson只能等待把??
                //其实这里有一个进行协同的约定是这样的
                // 1.chef生产的时候，会锁住waitPerson对象
                // 2.waitPerson消费的时候会锁住自身对象
                // 基于以上两点就可以发现对于临界变量的操作是同步的
                //但是直接对临界变量进行锁定，不是更好?也就没有上面这种隐形的约定了

                //其实还有一个原因就是调用notifyAll()的时候，也必须持有相对应的对象的锁
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
//                    notifyAll();
                }
//                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}