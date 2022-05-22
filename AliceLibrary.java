package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AliceLibrary {
    static Stack<Character> stack=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        Stack<Character> stack=putInStack(str);
        for(int i=0;i<stack.size();i++)
        {
            System.out.print(stack.get(i));
        }
    }

    private static Stack<Character> putInStack(String str) {
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch!='\\')
            {
                stack.push(ch);
            }
            else
            {
                String sub= getSubString(stack);
                stack=putInStack(sub);
            }
        }
        return stack;
    }

    private static String getSubString(Stack<Character> stack) {
        String s="";
        while(true)
        {
            char p=stack.pop();
            if(p=='/')
            {
                break;
            }
            s=s+p;
        }
        return s;
    }
}
