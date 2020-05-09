/**
 * 
 */
package org.msharma;

/**
 * @author kiran.goshika
 *
 */
public class GeneralApp {
	
	static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

     static void getCharCountArray(String str) 
     {
         for (int i = 0; i < str.length();  i++) {
              count[str.charAt(i)]++;
             
         }
     }

    static int firstNonRepeating(String str)
    {
        getCharCountArray(str);
        int index = -1, i;
      
        for (i = 0; i < str.length();  i++)
        {
            if (count[str.charAt(i)] == 1)
            {
                index = i;
                break;
            }   
        }  
       
      return index;
    }

    public static void main (String[] args)
    {
        String str = "geeksforgeeks";
        int index =  firstNonRepeating(str);
         
        System.out.println(index == -1 ? "Either all characters are repeating or string " +
                   "is empty" : "First non-repeating character is " +  str.charAt(index));
    }
	
}


		
		
		
		
		
		
//		permutation("", "xyz");
//
//	}
//	
//	public static void permutation(final String perm, final String word){
//		if(word.isEmpty())
//		{
//			System.out.println(perm);
//		}
//		else
//		{
//			for(int i=0;i<word.length();i++){
//				
//				String permutation = perm+word.charAt(i);
//				String arrangedWord = word.substring(0, i)+word.substring(i+1, word.length());
//				
//				permutation(permutation, arrangedWord);
//			}
//		}
//	}
//
//}
	

