package com.cjt.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {
	/**
	 * 获取某个日期的年份
	 * @param date
	 * @return
	 */
	public static Integer getYear(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        return cal.get(Calendar.YEAR);  
    } 
	 /** 
     * 获取某日期的月份 
     * @param date 
     * @return 
     */  
    public static Integer getMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        return cal.get(Calendar.MONTH) + 1;  
    }  
	/**
	 * 获取当前日期（yyyy-MM-dd）
	 * @return
	 */
	public static String getCurrentDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
	/**
	 * 获取当前时间（yyyy-MM-dd HH:mm:ss）
	 * @return
	 */
	public static String getCurrentTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
	/**
	 * 格式化时间类型（将时间类型转化为String类型）
	 * @param date Date类型 时间
	 * @param format String类型 时间格式
	 * @return
	 */
	public static String dateToString(Date date,String format){
		if(null==date || null== format){
			return null;
		}
		DateFormat dateformat=new SimpleDateFormat(format);
		return dateformat.format(date);
		
	}
	/**
	 * 格式化String时间
	 * @param time
	 * @param format
	 * @return
	 */
	public static Date StringToDate(String time,String format){
		if (time == null || time.equals("")) {  
            return null;  
        }
		Date date=null;  
        try{  
            DateFormat dateFormat=new SimpleDateFormat(format);  
            date=dateFormat.parse(time);  
        }catch(Exception e){  
            return null; 
        }  
        return date; 

	}
	/**
	 * 获取两个时间的天数差（yyyy-MM-dd 格式）
	 * @throws ParseException 
	 * 
	 */
	public static Integer getDayspace(String date1,String date2){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        long between_days=0;
        try {
			cal.setTime(sdf.parse(date1));
			long time1 = cal.getTimeInMillis();
		    cal.setTime(sdf.parse(date2));
		    long time2 = cal.getTimeInMillis();
		    between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int result = Integer.parseInt(String.valueOf(between_days));
        return Math.abs(result);
	}
	/**
	 * 字符串的日期格式的计算两个日期间相差月份 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static Integer getMonthspace(String date1,String date2){
		Date d1 = StringToDate(date1, "yyyy-MM-dd");
		Date d2 = StringToDate(date2, "yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
        // 获取月数差值
        int monthInterval =  (month1 + 12) - month2  ;
        if(day1 < day2) monthInterval --;
        monthInterval %= 12;
        return Math.abs(yearInterval * 12 + monthInterval);
	}
	/**
	 * 字符串的时间格式的计算两个时间相差分钟数 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Integer getMintuespace(String date1,String date2){
		Date time1 = StringToDate(date1, "yyyy-MM-dd hh:mm:ss");
		Date time2 = StringToDate(date2, "yyyy-MM-dd hh:mm:ss");
		long between = (time1.getTime() - time2.getTime())/1000;
		long min = between/60;
		return Math.abs((int) min);
	}
	
	public static String test(){
		System.out.println(111);
		System.out.println(222);
		return "111";
	}
}

