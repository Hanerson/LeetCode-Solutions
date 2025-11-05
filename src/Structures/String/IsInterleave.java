package Structures.String;

public class IsInterleave {
    public boolean isInterleave_(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()) return false;
        int ptr1 = 0,  ptr2 = 0, ptr3 = 0;
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray(),  arr3 = s3.toCharArray();
        while (ptr3 < s3.length()) {
            boolean match1 = (ptr1 < arr1.length && arr1[ptr1] == arr3[ptr3]);
            boolean match2 = (ptr2 < arr2.length && arr2[ptr2] == arr3[ptr3]);

            if (match1 && !match2) {
                ptr1++;
            } else if (!match1 && match2) {
                ptr2++;
            } else if (!match1) {
                return false;
            } else {
                return isInterleave_(
                        s1.substring(ptr1 + 1),
                        s2.substring(ptr2),
                        s3.substring(ptr3 + 1)
                )
                        || isInterleave_(
                        s1.substring(ptr1),
                        s2.substring(ptr2 + 1),
                        s3.substring(ptr3 + 1)
                );
            }
            ptr3++;
        }

        return true;
    }

    public boolean isInterleave(String s1, String s2, String s3){
        return false;
    }
}
