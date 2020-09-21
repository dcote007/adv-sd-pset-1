import java.util.List;

public class SimpleArrayList {
    private String[] lArray;
    public String printMe = "hi: ";
    public SimpleArrayList() {
        lArray = new String[0];
    }
    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity >= 0){
            lArray = new String[initialCapacity];
        } else {
            String s = "Illegal Capacity: " + initialCapacity;
            throw new IllegalArgumentException(s);
        }
    }
    public SimpleArrayList(List<String> list){
        if (list != null){
            lArray = list.toArray(new String[0]);
        } else {
            throw new NullPointerException();
        }
    }
    public void add(int index, String s){
        if (index >= 0 && index < lArray.length){
            String[] cpy = new String[lArray.length + 1];
            for(int i = 0; i < index; i++){
                cpy[i] = lArray[i];
            }
            cpy[index] = s;
            for(int d = index + 1; d < cpy.length; d++){
                int preD = d - 1;
                cpy[d] = lArray[preD];
            }
            lArray = cpy;
        } else {
            int initSize = lArray.length - 1;
            int finalSize = 0;
            for (int i=0; i <= initSize; i++){
            if (lArray[i] != null && lArray[i] != ""){
                finalSize++;
            }
        }
            String e = "Index: " + index + ", Size: " + finalSize;
            throw new IndexOutOfBoundsException(e);
        }
       
    }
    public boolean add(String s){
        int len = lArray.length;
        String[] tmpArr = new String[lArray.length + 1];    
        for (int i = 0; i < len; i++){
            //if (lArray[i] != null){
                tmpArr[i] = lArray[i];
            //}
        }
        tmpArr[lArray.length] = s;
        lArray = tmpArr;
        return true;
    }
    public void clear(){
        int lArrayIndex = lArray.length;
        lArray = new String[lArrayIndex];
    }
    public boolean contains(String s){
        int len = lArray.length - 1;
        boolean returnMe = false;
        for(int i = 0; i < len; i++){
            if (lArray[i] == s){
                returnMe = true;
            }
        }
        return returnMe;
    }
    public String get(int index){
        String returnMe;
        int len = lArray.length - 1;
        if (index >= 0 && index < len){
            returnMe = lArray[index];
        } else {
            String s = "Index " + index + " out of bounds for length " + lArray.length;
            throw new IndexOutOfBoundsException(s);
        }
        return returnMe;
    }
    public int indexOf(String s){
        for(int i = 0; i < lArray.length - 1; i++){
            if (lArray[i] == s){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        int initSize = lArray.length - 1;
        int finalSize = 0;
        for (int i=0; i <= initSize; i++){
            if (lArray[i] != null){
                finalSize++;
            }
        }
        if (finalSize == 0){
            return true;
        }
        return false;
    }
    public String remove(int index){
        int len = lArray.length - 1;
        String returnMe = "";
        if (index >= 0 && index <= len){
            returnMe = lArray[index];
            lArray[index] = null;
            if(index != len){
                for(int i = index; i < len; i++){
                    int mod = i + 1;
                    lArray[i] = lArray[mod];
                    lArray[++i] = null;
                }
            }
        } else {
            String s = "Index " + index + " out of bounds for length " + len;
            throw new IndexOutOfBoundsException(s);
        }
        return returnMe;
    }
    public boolean remove(String s){
        int len = lArray.length - 1;
        boolean setReturn = false;
        for(int i = 0; i <= len; i++){
            if (lArray[i] == s){
                lArray[i] = null;
                setReturn = true;
                for(int x = i; x < len; x++){
                    int mod = x + 1;
                    lArray[x] = lArray[mod];
                    lArray[++x] = null;
                }
            }
        }
        return setReturn;
    }
    public String set(int index, String s){
        String returnMe = "";
        if (index >= 0 && index < lArray.length){
            returnMe = lArray[index];
            if (s == null){
                s = "null";
            }
            if (s == ""){
                s = "";
            }
            lArray[index] = s;
        } else {
            String e = "Index " + index + " out of bounds for length " + lArray.length;
            throw new IndexOutOfBoundsException(e);
        }
        return returnMe;
    }
    public int size(){
        int initSize = lArray.length - 1;
        int finalSize = 0;
        for (int i=0; i <= initSize; i++){
            if (lArray[i] != null){
                finalSize++;
            }
        }
        return finalSize;
    }
    public void trimToSize(){
        int len = lArray.length - 1;
        for (int i = 0; i < len; i++){
            if (lArray[i] == null){
                for(int x = i; x < len; x++){
                    String strcpy = lArray[x];
                    lArray[x] = strcpy;
                    lArray[x] = null;
                }
            }
        }    
    }
    public String toString(){
        int len = lArray.length;
        String sep = ", ";
        String finalString = "";
        for(int i = 0; i < len; i++){
            if (lArray[i] != null && lArray[i] != ""){
                String modString = lArray[i];
                if (i != lArray.length - 1){
                    finalString = finalString + modString + sep;
                } else {
                    finalString = finalString + modString;
                }
            }
        }
        return "[" + finalString + "]";
    }
}