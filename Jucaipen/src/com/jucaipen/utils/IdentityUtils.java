package com.jucaipen.utils;
 
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**  
 *  �����֤ -- ��λ���ֵ�ַ�룬��λ���ֳ��������룬��λ����˳�����һλ����У����
 *  
 *  
 *  1. ��ַ�루ABCDEF������ʾ�������ס����������(�С��졢��)�������������룬��GB/T2260�Ĺ涨ִ�С�
    2. ���������루YYYYMMDD������ʾ�������������ꡢ�¡��գ���GB/T7408�Ĺ涨ִ�У��ꡢ�¡��շֱ���4λ��2λ��������λ��0����2λ��������λ��0�����ֱ�ʾ��֮�䲻�÷ָ�����
    3. ˳���루XXX������ʾ��ͬһ��ַ������ʶ������Χ�ڣ���ͬ�ꡢͬ�¡�ͬ�ճ������˱ඨ��˳��ţ�˳�����������������ԣ�ż�������Ů�ԡ�
    4��У���루R����һλ���֣�ͨ��ǰ17λ���ָ���һ������ó���������ֱ��ǡ�0��1��2������10����11�����֣���������Ϊ��10��ʱ��Ϊ�˱�֤�������֤����18λ�������á�X����ʾ��
 *
 */
public class IdentityUtils {
//    λȨֵ����
    private static byte[] Wi=new byte[17];
//    ���֤ǰ�����ַ���
    private static final byte fPart = 6;
//    ���֤�㷨��ģ�ؼ�ֵ
    private static final byte fMod = 11;
//    �����֤����
    private static final byte oldIDLen = 15;
//    �����֤����
    private static final byte newIDLen = 18;
//    �����֤��ݱ�־
    private static final String yearFlag = "19";
//    У���봮 
    private static final String CheckCode="10X98765432"; 
//    ��С������������
    private static final int minCode = 150000;
//    ��������������
    private static final int maxCode = 700000;
//    �����֤����
//    private String oldIDCard="";
//    �����֤����
//    private String newIDCard="";
//    ����������
    
    
    //private String Area[][2] = 
    private static void setWiBuffer(){
        for(int i=0;i<Wi.length;i++){    
            int k = (int) Math.pow(2, (Wi.length-i));
            Wi[i] = (byte)(k % fMod);
        }
    }
    
    //��ȡ�����֤�����һλ:����λ
    private static String getCheckFlag(String idCard){
        int sum = 0;
        //���м�Ȩ��� 
        for(int i=0; i<17; i++){        
            sum += Integer.parseInt(idCard.substring(i,i+1)) * Wi[i];
        }
        //ȡģ���㣬�õ�ģֵ
        byte iCode = (byte) (sum % fMod); 
        return CheckCode.substring(iCode,iCode+1);
    }
    
    //�жϴ����ȵĺϷ���
    private static boolean checkLength(final String idCard,boolean newIDFlag){
        boolean right = (idCard.length() == oldIDLen) || (idCard.length() == newIDLen);
        newIDFlag = false;
        if(right){
            newIDFlag = (idCard.length() == newIDLen);
        }
        return right;
    }
    
    //��ȡʱ�䴮
    private static String getIDDate(final String idCard,boolean newIDFlag){
        String dateStr = "";
        if(newIDFlag)
            dateStr = idCard.substring(fPart,fPart+8);
        else
            dateStr = yearFlag + idCard.substring(fPart,fPart+6);
        return dateStr;
    }
    
    //�ж�ʱ��Ϸ���
    private static boolean checkDate(final String dateSource){
        String dateStr = dateSource.substring(0,4)+"-"+dateSource.substring(4,6)+"-"+dateSource.substring(6,8);
        System.out.println(dateStr);
        DateFormat df = DateFormat.getDateInstance();
        df.setLenient(false);
        try {
            Date date= df.parse(dateStr);
            return (date!=null);
        } catch (ParseException e) {
        	System.out.println("err");
            return false;
        }
    }
    
    //�����֤ת���������֤����
    public static String getNewIDCard(final String oldIDCard){
        //��ʼ������
    	IdentityUtils.setWiBuffer();
        if(!checkIDCard(oldIDCard)){
            return oldIDCard;
        }
        String newIDCard = oldIDCard.substring(0, fPart);
        newIDCard += yearFlag;
        newIDCard += oldIDCard.substring(fPart, oldIDCard.length());
        String ch = getCheckFlag(newIDCard);
        newIDCard += ch;
        return newIDCard;
    }
    
    //�����֤ת���ɾ����֤����
    public static String getOldIDCard(final String newIDCard){
        //��ʼ������
    	IdentityUtils.setWiBuffer();
        if(!checkIDCard(newIDCard)){
            return newIDCard;
        }
        String oldIDCard = newIDCard.substring(0,fPart)+
                    newIDCard.substring(fPart+yearFlag.length(),newIDCard.length()-1);
        return oldIDCard;
    }
    
    //�ж����֤����ĺϷ���
    public static boolean checkIDCard(final String idCard){
        //��ʼ������
    	IdentityUtils.setWiBuffer();
        boolean isNew = true;
        //String message = "";
        if (!checkLength(idCard,isNew)){
            //message = "ID�����쳣";
        	System.out.println("ID�����쳣");
            return false;
        }
        String idDate = getIDDate(idCard, isNew);
        if(!checkDate(idDate)){
            //message = "IDʱ���쳣";
        	System.out.println("IDʱ���쳣");
            return false;
        }
        if(isNew){
            String checkFlag = getCheckFlag(idCard);
            String theFlag = idCard.substring(idCard.length()-1,idCard.length());
            if(!checkFlag.equals(theFlag)){
                //message = "�����֤У��λ�쳣";
            	System.out.println("�����֤У��λ�쳣");
                return false;
            }
        }
        return true;
    }
    
    //��ȡһ�������"α"���֤����
    public static String getRandomIDCard(final boolean idNewID){
        //��ʼ������
    	IdentityUtils.setWiBuffer();
        Random ran = new Random();
        String idCard = getAddressCode(ran)+getRandomDate(ran,idNewID)+getIDOrder(ran);
        if(idNewID){
            String ch = getCheckFlag(idCard);
            idCard += ch;
        }
        return idCard;
    }
    
    //��������ĵ�������
    private static String getAddressCode(Random ran) {
        if(ran==null){
            return "";
        }else{
            int addrCode = minCode + ran.nextInt(maxCode-minCode);
            return Integer.toString(addrCode);
        }
    }
    
    //��������ĳ�������
    private static String getRandomDate(Random ran, boolean idNewID) {
        if(ran==null){
            return "";
        }
        int year = 0;
        if(idNewID){
            year = 1900 + ran.nextInt(2007-1900);
        }else{
            year = 1 + ran.nextInt(99);
        }
        int month = 1+ran.nextInt(12);
        int day = 0;
        if(month==2){
            day= 1+ran.nextInt(28);
        }else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            day= 1+ran.nextInt(31);
        }else{
            day= 1+ran.nextInt(30);
        }
        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setMaximumIntegerDigits(2);
        nf.setMinimumIntegerDigits(2);
        String dateStr = Integer.toString(year)+nf.format(month)+nf.format(day);
        return dateStr;
    }
 
    //������������к�
    private static String getIDOrder(Random ran) {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setMaximumIntegerDigits(3);
        nf.setMinimumIntegerDigits(3);
        if(ran==null){
            return "";
        }else{
            int order = 1+ran.nextInt(999);
            return nf.format(order);
        }
    }
 
    public IdentityUtils(){
        setWiBuffer();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        String randomID=IdentityUtils.getRandomIDCard(true);
        System.out.println("������֤��"+randomID);
        /*
        String oldID="";
        String newID=Identity.getNewIDCard(oldID);
        System.out.println("�����֤��"+oldID);
        System.out.println("�����֤��"+newID);
        String oldCard = Identity.getOldIDCard(newID);
        System.out.println("�����֤��"+oldCard);
        /*
        String dateSource="2000-9-30";
        if(id.checkDate(dateSource))
            System.out.println("��ȷʱ�䴮��"+dateSource);
        else
            System.out.println("����ʱ�䴮��"+dateSource);
         * 
         * 
         */
    }
    
    
    /**
     * @param idNum
     * @return  �ж����֤���Ƿ�Ϸ�
     */
    public static boolean isIdCard(String idNum){
    	   //�����б��û����֤�ŵ�������ʽ��Ҫô��15λ��Ҫô��18λ�����һλ����Ϊ��ĸ��  
        Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");  
        //ͨ��Pattern���Matcher  
        Matcher idNumMatcher = idNumPattern.matcher(idNum);  
        //�ж��û������Ƿ�Ϊ���֤��  
        if(idNumMatcher.matches()){  
            //����ǣ�����������ʽ��ȡ�����֤�еĳ�������  
            Pattern birthDatePattern= Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");//���֤�ϵ�ǰ6λ�Լ�����������  
            //ͨ��Pattern���Matcher  
            Matcher birthDateMather= birthDatePattern.matcher(idNum);  
            //ͨ��Matcher����û��ĳ���������  
            if(birthDateMather.find()){  
                String year = birthDateMather.group(1);  
                String month = birthDateMather.group(2);  
                String date = birthDateMather.group(3);  
                //����û��ĳ���������  
                System.out.println("�������ڣ�"+year+"��"+month+"��"+date+"��");                  
            }   
            return true;
        }else{  
            //������ǣ������Ϣ��ʾ�û�  
            System.out.println("������Ĳ��������֤��");  
            return false;  
        }
    }
    
    
    
}