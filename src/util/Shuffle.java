package util;
/** 
* @author: jan 
* @date: 2018年5月13日 下午1:18:47 
*/
import java.util.ArrayList;    
import java.util.Collections;    
import java.util.Iterator;    
import java.util.List;    
    
    
public class Shuffle {    
        
    public static void main(String[] args) {    
        shuffle();    
    }    
        
    public static void shuffle(){    
        int[] x = {1,2,3,4,5,6,7,8,9};    
        List<Integer> list = new ArrayList();    
        for(int i = 0;i < x.length;i++){    
            System.out.print(x[i]+", ");    
            list.add(x[i]);    
        }    
        System.out.println();    
            
        Collections.shuffle(list); 
        for(Integer i : list) {
        	System.out.print(i + ", ");
        }
            
//        Iterator ite = list.iterator();    
//        while(ite.hasNext()){    
//            System.out.print(ite.next().toString()+", ");    
//        }    
    }    
} 