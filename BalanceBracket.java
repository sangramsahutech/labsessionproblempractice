package com.gl.practice.BalancingBracket;
import java.util.*;
public class BalanceBracket {
	public static void main(String[] args) {
		String str = "{([])}";
		boolean status = ispar(str);
		System.out.print(status);
	}
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        int[] res = new int[x.length()];
        int k=0, count=0;
        for(int i=0;i<x.length();i++){
            char ch = x.charAt(i);
            if(ch =='{')
                res[i] = 1;
            else if(ch=='(')
                res[i] = 2;
            else if(ch=='[')
                res[i]=3;
            else if(ch=='}'){
                res[i] =  -1;
                for(k=i-1;k>=0;k--){
                    if(res[k]!=0){
                        if(res[k]!=-res[i])
                            return false;
                        else{
                            res[k]=0;
                            res[i]=0;
                            k=0;
                        }
                    } 
                }
            }
            else if(ch==')'){
                res[i] = -2;
                for(k=i-1;k>=0;k--){
                    if(res[k]!=0){
                        if(res[k]!=-res[i])
                            return false;
                        else{
                            res[k]=0;
                            res[i]=0;
                            k=0;
                        }
                    } 
                }
            }
            else if(ch==']'){
                res[i] = -3;
                for(k=i-1;k>=0;k--){
                    if(res[k]!=0){
                        if(res[k]!=-res[i])
                            return false;
                        else{
                            res[k]=0;
                            k=0;
                            res[i]=0;
                        }
                    } 
                }
            }
        }
        for(int i=0;i<x.length();i++){
            if(res[i]==0)
                count++;
        }
        if(count==x.length())
            return true;
        else
            return false;
    }
}
