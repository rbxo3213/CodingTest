package CodingTest;

import java.io.*;

public class BOJ9653{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<10; i++){
            bw.write(br.readLine()+"\n");
        }
        bw.write(br.readLine());
        bw.flush();
        bw.close();
        br.close();
    }
}