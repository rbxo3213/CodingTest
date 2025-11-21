import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class BOJ2108{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        for(int i = 0; i<n; i++){
            list[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        System.out.println(avg(list));
        System.out.println(median(list));
        System.out.println(mode(list));
        System.out.println(range(list));

    }
    public static int avg(int[] list){
        int total = 0;
        for(int i : list){
            total+=i;
        }
        int result = (int)Math.round((double)total/list.length);
        if(result == -0) return -result;
        return result;     
    }
    public static int median(int[] list){
        return list[list.length/2];
    }
    public static int mode(int[] list) {
    	Stack<int[]>stack = new Stack<>();
    	int count=1;
    	for(int i = 0; i<list.length-1; i++) {
    		if(list[i]==list[i+1]) count++;
    		else {
    			//stack.push(new int[] {i,count});
    			if(!stack.isEmpty()) {
    				if(stack.peek()[1]<count) {
    					stack.pop();
    					stack.push(new int[] {i,count});
    				}else if(stack.peek()[1]<=count) {
    					stack.push(new int[] {i,count});
    				}
    			} else stack.push(new int[] {i,count});
    			count = 1;
    		}
    	}
    	
    	if(stack.size()>1) {
    		while(stack.size()==2) {
    			stack.pop();
    		} // -2 1 2 3 8
    		return stack.peek()[0];
    	}
    	return stack.peek()[0];
    }
    public static int range(int[] list){
        int tmp = list[list.length-1]-list[0];
        if (tmp<0) return -tmp;
        return tmp;
    }
}