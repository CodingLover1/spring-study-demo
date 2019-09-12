import java.sql.SQLOutput;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shuo.wang
 * @date 19-8-26
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),(r,executor)->{
            System.out.print("Active Count="+executor.getActiveCount());
            System.out.print(" Largest Pool Size="+executor.getLargestPoolSize());
            System.out.print(" Max Pool Size="+executor.getMaximumPoolSize());
            System.out.println(" Pool Size="+executor.getPoolSize());
        });

        for(int i=0;i<100;i++){
            final int x=i;
            threadPoolExecutor.submit(()->{
                System.out.println("开始执行任务:"+x);
                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }
                System.out.println("任务:"+x+"执行完毕");
            });
        }

        threadPoolExecutor.shutdown();
        while(!threadPoolExecutor.isTerminated()){
            try {
                Thread.sleep(100);
            }catch (Exception e){

            }
        }


    }
}
