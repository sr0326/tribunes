package com.zxh.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	
	 private static String filenameTemp;
	/**
	 * 单文件上传
	 * 
	 * @param file
	 * @param path
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 * @throws IllegalStateException
	 */
	public static String upload(MultipartFile file, File path) throws IllegalStateException, IOException{
		checkDirectory(path);
		//获取文件名
		String a=file.getOriginalFilename();
		
		String filename=UUID.randomUUID()+getSuffix(a);
		String aa=path+"/"+filename;
		File f=new File(aa);
		file.transferTo(f);
		
		return filename;
	}
	
	/**
	 * 多文件上传
	 * 
	 * @param file
	 * @param path
	 * @return
	 * @throws Exception
	 * @throws IllegalStateException
	 */
	public static String[] uploads(MultipartFile[] file, File[] path)
			throws IllegalStateException, Exception {
		int length = file.length;
		String[] str = new String[length];
		for (int i = 0; i < str.length; i++) {
			str[i] = upload(file[i], path[i]);
		}
		return str;
	}

	/**
	 * 截取文件后缀<br>
	 * 例如：.jpg
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 检测目录是否存在
	 * 
	 * @param file
	 */
	public static void checkDirectory(File file) {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
	}
	
	 /**
     * 创建文件
     * @param fileName  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static String createFile(String txtpath,String fileName,String filecontent){
        filenameTemp = txtpath+fileName+".txt";//文件路径+名称+文件类型
        File file = new File(filenameTemp);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
                System.out.println("success create file,the file is "+filenameTemp);
                //创建文件成功后，写入内容到文件里
                writeFileContent(filenameTemp, filecontent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "txt/"+fileName+".txt";
    }

    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";
        
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis,"utf-8");
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            
            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);
            
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }
    /**
     * 读入TXT文件
     */
    public static String readFile(String pathname) {
        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        String result="";
    	try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //System.out.println(line);
                result+=line+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return result;
    }


}
