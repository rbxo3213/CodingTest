//https://school.programmers.co.kr/learn/courses/30/lessons/17686
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        File[] fileArray = new File[files.length];
        
        for (int i = 0; i < files.length; i++) {
            fileArray[i] = new File(files[i]);
        }
        
        Arrays.sort(fileArray);
        
        for (int i = 0; i < fileArray.length; i++) {
            answer[i] = fileArray[i].originalStr;
        }
        
        return answer;
    }
}
class File implements Comparable<File> {
    String head;
    int number;
    String originalStr;
    
    public File(String fileName) {
        this.originalStr = fileName;
        parse(fileName);
    }
    
    private void parse(String fileName) {
        int firstDigit = 0;
        
        while (firstDigit < fileName.length() && (fileName.charAt(firstDigit) < '0' || fileName.charAt(firstDigit) > '9')) {
            firstDigit++;
        }
        
        int endDigit = firstDigit;
        
        while (endDigit < fileName.length() && (fileName.charAt(endDigit) >= '0' && fileName.charAt(endDigit) <= '9') && endDigit - firstDigit < 5) {
            endDigit++;
        }
        
        this.head = fileName.substring(0, firstDigit).toLowerCase();
        this.number = Integer.parseInt(fileName.substring(firstDigit, endDigit));
    }
    
    @Override
    public int compareTo(File o) {
        int headCompare = this.head.compareTo(o.head);
        
        if (headCompare == 0) {
            return this.number - o.number;
        }
        return headCompare;
    }
}
