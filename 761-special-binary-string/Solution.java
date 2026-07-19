// class Solution {
//     public String makeLargestSpecial(String s) {
//         List<String> strings = new ArrayList<>();
//         int balance = 0;
//         int start = 0;
        
//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i) == '1') balance++;
//             else balance--;
        
//             if(balance == 0){
//                 // System.out.println("hello " + s.substring(start + 1, i));
//                 String inner = makeLargestSpecial(s.substring(start + 1, i));
//                 strings.add('1' + inner + '0');
//                 start = i + 1;
//             }
//         }
        
//         Collections.sort(strings, Collections.reverseOrder());
//         StringBuilder out = new StringBuilder();
//         for(String sub: strings){
//             System.out.println(sub);
//             out.append(sub);
//         }
//         return out.toString();
//     }
// }
class Solution {

    public String makeLargestSpecial(String s) {

        System.out.println("\n==================================");
        System.out.println("Call : " + s);

        List<String> list = new ArrayList<>();

        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1')
                balance++;
            else
                balance--;

            System.out.println(
                "i = " + i +
                "  char = " + s.charAt(i) +
                "  balance = " + balance +
                "  start = " + start
            );

            if (balance == 0) {

                System.out.println("\nBalance became 0");
                System.out.println("start = " + start + ", i = " + i);
                System.out.println("Special Substring = "
                        + s.substring(start, i + 1));

                String innerString = s.substring(start + 1, i);

                System.out.println("Inner = " + innerString);

                String inner = makeLargestSpecial(innerString);

                String current = "1" + inner + "0";

                System.out.println("Current Special = " + current);

                list.add(current);

                start = i + 1;

                System.out.println("Move start to " + start);
            }
        }

        System.out.println("\nBefore Sort : " + list);

        Collections.sort(list, Collections.reverseOrder());

        System.out.println("After Sort  : " + list);

        StringBuilder ans = new StringBuilder();

        for (String str : list)
            ans.append(str);

        System.out.println("Return : " + ans);

        return ans.toString();
    }
}