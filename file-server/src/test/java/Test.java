import java.io.File;
import java.io.FileInputStream;

/**
 * @author shuo.wang
 * @date 19-9-17
 */
public class Test {

    @org.junit.Test
    public void fileTest(){
        try {
            File file = new File("/home/shuowang/gitrepo/spring-demo/file-server/build/classes/java/main/upload/b8ce8f5b93c64c5bb46b873f082bf0c9");

            byte[] buffer = new byte[1024];
            FileInputStream in = new FileInputStream(file);
            int i=in.read(buffer);
            while(i!=-1){
                i=in.read(buffer);
            }

            if(in!=null){
                in.close();
            }

        }catch (Exception e){

        }

    }

}
