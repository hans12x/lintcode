/*1394. Goat Latin
中文English
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.

For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append
it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.

Example
Example1

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example2

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
Notice
S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
*/
public class Solution {
    /**
     * @param S: 
     * @return: nothing
     */
    public String  toGoatLatin(String S) {
        String[] list = S.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> dict = new HashSet<>();
        dict.add('a');
        dict.add('e');
        dict.add('i');
        dict.add('o');
        dict.add('u');
        dict.add('A');
        dict.add('E');
        dict.add('I');
        dict.add('O');
        dict.add('U');
        for (int i=0;i< list.length ;i++ ){
            if(sb.length()>0){
                sb.append(" ");
            }
            StringBuilder temp = new StringBuilder();
            if(dict.contains(list[i].charAt(0)) == true ){
                temp.append(list[i]+"ma");
            }
            else{
                temp.append(list[i].substring(1)+list[i].substring(0,1) +"ma");
            }
            int count = 0;
            while(count <= i){
                temp.append("a");
                count++;
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}