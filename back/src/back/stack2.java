package back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class stack2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        Stack<Long> stack = new Stack<>();

        for(int i=0; i<N; i++) {
           Long input = Long.parseLong(br.readLine());

           while(!stack.isEmpty()) {
               if(stack.peek()<=input)
                   stack.pop();
               else
                   break;
           }
           cnt += stack.size();
           stack.push(input);
        }
        System.out.println(cnt);
    }
}
