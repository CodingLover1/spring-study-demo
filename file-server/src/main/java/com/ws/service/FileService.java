package com.ws.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author shuo.wang
 * @date 19-9-17
 */

@Service
public class FileService {

    private String uploadDir;

    public FileService(){
        try {
            File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(rootPath.getAbsolutePath(), "upload");
            if (!upload.exists()) {
                upload.mkdirs();
            }

            uploadDir = upload.getAbsolutePath();
        }catch (FileNotFoundException e){
            uploadDir="/data/upload";
        }
    }

    public void uploadFiles(MultipartFile[] files)throws Exception{

            for(MultipartFile file:files){
                String fileName= UUID.randomUUID().toString().replace("-","");
                File targetFile=new File(uploadDir+File.separator+fileName);
                FileOutputStream fileOutputStream=new FileOutputStream(targetFile);
                IOUtils.copy(file.getInputStream(),fileOutputStream);
                fileOutputStream.close();
            }
    }

    public String uploadFile(MultipartFile file)throws Exception{

        String fileName= UUID.randomUUID().toString().replace("-","");
        File targetFile=new File(uploadDir+File.separator+fileName);
        FileOutputStream fileOutputStream=new FileOutputStream(targetFile);
        IOUtils.copy(file.getInputStream(),fileOutputStream);
        fileOutputStream.close();
        return fileName;

    }

    public void downloadFile (String fileName, HttpServletRequest request, HttpServletResponse response)throws Exception {
        File file=new File(uploadDir,fileName);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));

            byte[] buffer=new byte[1024];
            FileInputStream in=new FileInputStream(file);
            BufferedInputStream bin=new BufferedInputStream(in);

            OutputStream out=response.getOutputStream();

            int i=bin.read(buffer);
            while(i!=-1){
                out.write(buffer,0,i);
                i=bin.read(buffer);
            }

            if(bin!=null){
                bin.close();
            }

            if(in!=null){
                in.close();
            }

        }
    }

    /**
     * 支持断点续传
     * @param fileName
     * @param request
     * @param response
     */
    public void downloadFile2(String fileName, HttpServletRequest request,HttpServletResponse response)throws Exception{
            File targetFile=new File(uploadDir,fileName);

            response.setContentType("application/oct-stream");
            response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
            response.setHeader("Accept-Ranges","bytes");

            long fileLength=targetFile.length();
            long fromPos=0,toPos=0;

            int downloadSize;
            if(request.getHeader("Range")==null){
                response.setContentLengthLong(fileLength);
                downloadSize=(int)fileLength;
            }else {
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                String range = request.getHeader("Range");
                String bytes = range.replaceAll("bytes=", "");
                String[] arr = bytes.split("-");
                if (arr.length == 2) {
                    toPos = Long.parseLong(arr[1]);
                }

                if (toPos > fromPos) {
                    downloadSize = (int)(toPos - fromPos);
                } else {
                    downloadSize =(int) (fileLength - fromPos);
                }

                response.setContentLengthLong(downloadSize);
            }

            RandomAccessFile in=new RandomAccessFile(targetFile,"rw");
            OutputStream out=response.getOutputStream();

            if(fromPos>0)
                in.seek(fromPos);

            int bufLen=downloadSize< 2048?downloadSize:2048;
            byte[] buffer=new byte[bufLen];

            int i=in.read(buffer);
            int count=0;
            while(i!=-1){
                out.write(buffer,0,i);
                count+=i;
                //计算不满缓冲区的大小
                if(downloadSize-count<bufLen){
                    bufLen=downloadSize-count;
                    if(bufLen==0){
                        break;
                    }
                    buffer=new byte[bufLen];
                }

                i=in.read(buffer);
            }
            response.flushBuffer();
            if(in!=null){
                in.close();
            }

            if(out!=null){
                out.close();
            }
    }
}
